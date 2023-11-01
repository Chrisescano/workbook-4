package org.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DealershipFileManager {

    public static void main(String[] args) {

    }

    public Dealership getDealership() {
        Dealership dealershipFromFile = null;

        //load from inventory.csv file [done]
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));

            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                String[] tokens = fileLine.split("\\|");

                //create a Dealership object
                if(tokens.length == 3) {
                    dealershipFromFile = new Dealership(tokens[0], tokens[1], tokens[2]);
                    continue;
                }

                //populate the Dealership object with Vehicles
                dealershipFromFile.addVehicle(new Vehicle(
                        Integer.parseInt(tokens[0]),    //vin number
                        Integer.parseInt(tokens[1]),    //year
                        tokens[2],                      //make
                        tokens[3],                      //model
                        tokens[4],                      //vehicle type
                        tokens[5],                      //color
                        Integer.parseInt(tokens[6]),    //mileage
                        Double.parseDouble(tokens[7])   //price
                ));
            }
            return dealershipFromFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //educated guess: a string for parameter
    public void saveDealership(String dealership) {
        //this could be anything
        //but I know that it has to do with a csv file
    }
}
