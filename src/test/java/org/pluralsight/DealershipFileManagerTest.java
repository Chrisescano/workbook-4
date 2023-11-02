package org.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DealershipFileManagerTest {
    DealershipFileManager fileManager = new DealershipFileManager();
    Dealership dealership = fileManager.getDealership();

    @Test
    void getDealership() {
        assertEquals("Evie's Dealership|123 Park Avenue|123-456-7890", dealership.toString());
    }

    @Test
    void saveDealership() {
        //add a vehicle to it
        dealership.addVehicle(new Vehicle(
                12345, 2020,"Ford", "Raptor", "Car", "Black", 20, 34000
        ));

        //save dealership
        fileManager.saveDealership(dealership);

        //take dealership.toString and compare to BufferedReader
        Dealership newDealership = fileManager.getDealership();

        String dealershipFile = newDealership.toString();
        for(Vehicle vehicle : newDealership.getInventory()) {
            dealershipFile += vehicle.toString();
        }

        assertEquals(true, dealershipFile.equals("Evie's Dealership|123 Park Avenue|123-456-7890" +
                "10112|2020|Tesla|Model S|Car|Red|500|89000.0" +
                "12342|2021|Tesla|Model X|Car|Black|2300|91000.0" +
                "14673|2022|Tesla|Model 3|Car|Gold|0|130000.0" +
                "12345|2020|Ford|Raptor|Car|Black|20|34000.0"));
    }
}