package org.pluralsight;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {

    }

    public void display() {
        init();

        while (true) {
            displayMenu();
            char command = getCharInput("Type in command: ");
            switch (command) {
                case 'D' -> processGetAllVehiclesRequest();
                case 'P' -> processGetByPriceRequest();
                case 'M' -> processGetByMakeModelRequest();
                case 'Y' -> processGetByYearRequest();
                case 'C' -> processGetByColorRequest();
                case 'T' -> processGetByVehicleTypeRequest();
                case 'O' -> processGetByMileage();
                case 'A' -> processAddVehicleRequest();
                case 'R' -> processRemoveVehicleRequest();
                case 'S' -> processSellOrLeaseVehicle();
                case 'X' -> { return; }
                default -> System.out.println("Not A Valid Command, Try Again");
            }
        }
    }

    /*-----Private Methods-----*/
    private void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    private void processGetByPriceRequest() {
        System.out.println("==========[ Price Search ]==========");
        double min = getDoubleInput("Enter Minimum Price: ");
        double max = getDoubleInput("Enter Maximum Price: ");
        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    private void processGetByMakeModelRequest() {
        System.out.println("==========[ Make/Model Search ]==========");
        String make = getStringInput("Enter Make: ");
        String model = getStringInput("Enter Model: ");
        displayVehicles(dealership.getVehiclesByMakeModel(make, model));
    }

    private void processGetByYearRequest() {
        System.out.println("==========[ Year Search ]==========");
        int min = getIntInput("Enter Minimum Year: ");
        int max = getIntInput("Enter Maximum Year: ");
        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    private void processGetByColorRequest() {
        System.out.println("==========[ Color Search ]==========");
        String color = getStringInput("Enter Color Value: ");
        displayVehicles(dealership.getVehiclesByColor(color));
    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("==========[ Vehicle Type Search ]==========");
        String vehicleType = getStringInput("Enter Vehicle Type: ");
        displayVehicles(dealership.getVehicleByType(vehicleType));
    }

    private void processGetByMileage() {
        System.out.println("==========[ Mileage Search ]==========");
        int min = getIntInput("Enter Minimum Mileage: ");
        int max = getIntInput("Enter Maximum Mileage: ");
        displayVehicles(dealership.getVehicleByMileage(min, max));
    }

    private void processAddVehicleRequest() {
        System.out.println("==========[ Add Vehicle ]==========");
        int vin = getIntInput("Enter Vehicle Vin (5-digit): ");
        int year = getIntInput("Enter Vehicle Year: ");
        String make = getStringInput("Enter Vehicle Make: ");
        String model = getStringInput("Enter Vehicle Model: ");
        String vehicleType = getStringInput("Enter Vehicle Type: ");
        String color = getStringInput("Enter Vehicle Color: ");
        int odometer = getIntInput("Enter Vehicle Mileage: ");
        double price = getDoubleInput("Enter Vehicle Price: ");

        dealership.addVehicle(new Vehicle(
                vin, year, make, model, vehicleType, color, odometer, price
        ));
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(this.dealership);
    }

    private void processRemoveVehicleRequest() {
        System.out.println("==========[ Remove Vehicle ]==========");
        int vin = getIntInput("Enter Vehicle Vin: ");

        System.out.println("Removing...");
        List<Vehicle> vehicles = dealership.getVehiclesByVin(vin);
        displayVehicles(vehicles);

        if (vehicles.size() > 0) dealership.removeVehicle(vehicles.get(0));
        else return; //if empty do nothing return

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(this.dealership);
    }

    private void processSellOrLeaseVehicle() {
        System.out.println("==========[ Contract Menu ]==========");
        String date = getStringInput("Enter Current Date: ");
        String name = getStringInput("Enter Your Name: ");
        String email = getStringInput("Enter Your Email: ");
        int vin = getIntInput("Enter Vin Of Vehicle: ");
        List<Vehicle> vehicle = dealership.getVehiclesByVin(vin);

        String typeOfContract = getStringInput("Would you like to buy or lease").toUpperCase();
        Contract contract = null;
        if (typeOfContract.equalsIgnoreCase("LEASE")) {
            contract = new LeaseContract(date, name, email, vehicle.get(0));
        } else if(typeOfContract.equalsIgnoreCase("BUY")) {
            boolean isFinanced = getBooleanInput("Would you like to finance the vehicle?");
            contract = new SalesContract(date, name, email, vehicle.get(0), isFinanced);
        }

        ContractDataManager contractDataManager = new ContractDataManager();
        contractDataManager.saveContract(contract);
        dealership.removeVehicle(vehicle.get(0));

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(dealership);
    }

    /*-----Helper Methods-----*/
    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    private void displayMenu() {
        System.out.print("""
                ==========[ Main Menu ]==========
                  (D) - Display All Vehicles
                  (P) - Display Vehicles By Price
                  (M) - Display Vehicles By Make and Model
                  (Y) - Display Vehicles By Year
                  (C) - Display Vehicles By Color
                  (T) - Display Vehicles By Type
                  (O) - Display Vehicles By Mileage
                  (S) - Sell/Lease A Vehicle
                  (X) - Exit The Application
                """);
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
        System.out.println(); //formatting
    }

    /*-----I/O Methods-----*/
    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private char getCharInput(String prompt) {
        return getStringInput(prompt).toUpperCase().charAt(0);
    }

    private int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Was Expecting An Integer. Try Again");
            }
        }
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double input = scanner.nextDouble();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Was Expecting An Integer. Try Again");
            }
        }
    }

    private boolean getBooleanInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            try {
                boolean input = scanner.nextBoolean();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Was Expecting true or false. Try Again");
            }
        }
    }
}
