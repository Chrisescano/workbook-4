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

    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        return null;
    }

    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return null;
    }

    public List<Vehicle> getVehiclesByYear(int min, int max) {
        return null;
    }

    public List<Vehicle> getVehiclesByColor(String color) {
        return null;
    }

    public List<Vehicle> getVehicleByMileage(int min, int max) {
        return null;
    }

    public List<Vehicle> getVehicleByType(String vehicleType) {
        return null;
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
