package org.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealershipTest {
    Dealership dealership = new Dealership("Dealers", "123 road street", "123-456-7890");
    Vehicle vehicle = new Vehicle(12345, 2020,"Ford", "Raptor", "Car", "Black", 20, 34000);

    @Test
    public void testAddVehicle() {
        dealership.addVehicle(vehicle);
        assertEquals(1, dealership.getInventory().size());
    }

    @Test
    public void testRemoveVehicle() {
        dealership.addVehicle(vehicle);
        dealership.removeVehicle(vehicle);
        assertEquals(false, dealership.getInventory().contains(vehicle));
    }
}