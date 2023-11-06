package org.pluralsight;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@TestWithResources
class DealershipFileManagerTest {
    DealershipFileManager fileManager = new DealershipFileManager();
    Dealership dealership = fileManager.getDealership();

    @GivenTextResource("testinventory.csv")
    String testInventory;

    @Test
    void getDealership() {
        assertEquals("Evie's Dealership|123 Park Avenue|123-456-7890", dealership.toString());
    }

    @Test
    void saveDealership() {
        //save dealership
        fileManager.saveDealership(dealership);

        //take dealership.toString and compare to BufferedReader
        Dealership newDealership = fileManager.getDealership();

        String dealershipFile = newDealership.toString() + "\n";
        for(Vehicle vehicle : newDealership.getInventory()) {
            dealershipFile += vehicle.toString() + "\n";
        }

        assertEquals(testInventory.replaceAll("\\r\\n","\n"), dealershipFile);
    }
}