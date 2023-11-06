package org.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {

    }

    public void display() {
        init();

        while (true) {
            displayMenu();
            char command = getCharInput("Type in command:" );
            switch (command) {
                case 'D' -> processGetAllVehiclesRequest();
                case 'X' -> { return; }
                default -> System.out.println("Not A Valid Command, Try Again");
            }
        }
    }

    public void processGetByPriceRequest() {

    }

    public void processGetByMakeModelRequest() {

    }

    public void processGetByYearRequest() {

    }

    public void processGetByColorRequest() {

    }

    public void processGetByMileage() {

    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processGetAllVehiclesRequest() {
        displayVehicles(dealership.getAllVehicles());
    }

    public void processAddVehicleRequest() {

    }

    public void processRemoveVehicleRequest() {

    }

    /*-----Private Methods-----*/
    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    private void displayMenu() {
        System.out.print("""
                ==========[ Main Menu ]==========
                  (D) - Display All Vehicles
                  (X) - Exit The Application
                """);
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
        System.out.println(); //formatting
    }

    private char getCharInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().toUpperCase().charAt(0);
    }
}
