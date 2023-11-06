package org.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        inventory = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByVin(int vin) {
        ArrayList<Vehicle> filteredList = new ArrayList<>(inventory);
        filteredList.removeIf(vehicle -> vehicle.getVin() != vin);
        return filteredList;
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        ArrayList<Vehicle> filteredList = new ArrayList<>(inventory);
        filteredList.removeIf(vehicle -> vehicle.getPrice() < min || vehicle.getPrice() > max);
        return filteredList;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        ArrayList<Vehicle> filteredList = new ArrayList<>(inventory);
        filteredList.removeIf(vehicle -> !vehicle.getMake().contains(make));
        filteredList.removeIf(vehicle -> !vehicle.getModel().contains(model));
        return filteredList;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        ArrayList<Vehicle> filteredList = new ArrayList<>(inventory);
        filteredList.removeIf(vehicle -> vehicle.getYear() < min || vehicle.getYear() > max);
        return filteredList;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        ArrayList<Vehicle> filteredList = new ArrayList<>(inventory);
        filteredList.removeIf(vehicle -> !vehicle.getColor().contains(color));
        return filteredList;
    }

    public List<Vehicle> getVehicleByMileage(int min, int max) {
        ArrayList<Vehicle> filteredList = new ArrayList<>(inventory);
        filteredList.removeIf(vehicle -> vehicle.getOdometer() < min || vehicle.getOdometer() > max);
        return filteredList;
    }

    public List<Vehicle> getVehicleByType(String vehicleType) {
        ArrayList<Vehicle> filteredList = new ArrayList<>(inventory);
        filteredList.removeIf(vehicle -> !vehicle.getVehicleType().contains(vehicleType));
        return filteredList;
    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    /*-----Getters-----*/

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public ArrayList<Vehicle> getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return name+"|"+address+"|"+phone;
    }
}
