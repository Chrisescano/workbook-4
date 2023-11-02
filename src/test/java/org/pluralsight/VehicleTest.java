package org.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    Vehicle vehicle = new Vehicle(12345, 2020,"Ford", "Raptor", "Car", "Black", 20, 34000);

    @Test
    public void testingCarVin() {
        assertEquals(12345, vehicle.getVin());
    }

    @Test
    public void testingCarYear() {
        assertEquals(2020, vehicle.getYear());
    }

    @Test
    public void testingCarMake() {
        assertEquals("Ford", vehicle.getMake());
    }

    @Test
    public void testingCarModel() {
        assertEquals("Raptor", vehicle.getModel());
    }

    @Test
    public void testingCarType() {
        assertEquals("Car", vehicle.getVehicleType());
    }

    @Test
    public void testingCarColor() {
        assertEquals("Black", vehicle.getColor());
    }

    @Test
    public void testingCarOdometer() {
        assertEquals(20, vehicle.getOdometer());
    }

    @Test
    public void testingCarPrice() {
        assertEquals(34000, vehicle.getPrice());
    }
}