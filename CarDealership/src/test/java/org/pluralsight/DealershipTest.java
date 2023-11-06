package org.pluralsight;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {
    @Test
    public void testAddVehicle() {
        Dealership dealership = new Dealership("Dealers", "123 road street", "123-456-7890");
        Vehicle vehicle = new Vehicle(12345, 2020,"Ford", "Raptor", "Car", "Black", 20, 34000);

        dealership.addVehicle(vehicle);
        assertEquals(1, dealership.getInventory().size());
    }

    @Test
    public void testRemoveVehicle() {
        Dealership dealership = new Dealership("Dealers", "123 road street", "123-456-7890");
        Vehicle vehicle = new Vehicle(12345, 2020,"Ford", "Raptor", "Car", "Black", 20, 34000);

        dealership.addVehicle(vehicle);
        dealership.removeVehicle(vehicle);
        assertEquals(false, dealership.getInventory().contains(vehicle));
    }

    @Test
    public void testGetVehicleByVin() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.getDealership();
        List<Vehicle> vehicle = dealership.getVehiclesByVin(10112);

        assertEquals(dealership.getInventory().get(0), vehicle.get(0));
    }

    @Test
    public void testGetVehiclesByPrice() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.getDealership();
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(0, 50000);

        assertEquals(dealership.getInventory().get(3), vehicles.get(0));
        assertEquals(1, vehicles.size());
    }

    @Test
    public void testGetVehiclesByMakeModel() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.getDealership();
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel("Tesla","Model S");

        assertEquals(dealership.getInventory().get(0), vehicles.get(0));
        assertEquals(1, vehicles.size());
    }

    @Test
    public void testGetVehiclesByYear() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.getDealership();
        List<Vehicle> vehicles = dealership.getVehiclesByYear(2020, 2020);

        assertEquals(2, vehicles.size());
        assertEquals(dealership.getInventory().get(0), vehicles.get(0));
        assertEquals(dealership.getInventory().get(3), vehicles.get(1));
    }

    @Test
    public void testGetVehicleByColor() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.getDealership();
        List<Vehicle> vehicles = dealership.getVehiclesByColor("Black");

        assertEquals(1, vehicles.size());
        assertEquals(dealership.getInventory().get(1), vehicles.get(0));
    }

    @Test
    public void testGetVehicleByMileage() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.getDealership();
        List<Vehicle> vehicles = dealership.getVehicleByMileage(0, 1);

        assertEquals(1, vehicles.size());
        assertEquals(dealership.getInventory().get(2), vehicles.get(0));
    }

    @Test
    public void testGetVehicleByType() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        Dealership dealership = dealershipFileManager.getDealership();
        List<Vehicle> vehicles = dealership.getVehiclesByColor("Gold");

        assertEquals(1, vehicles.size());
        assertEquals(dealership.getInventory().get(2), vehicles.get(0));
    }
}