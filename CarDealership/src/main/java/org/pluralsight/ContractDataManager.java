package org.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

    public void saveContract(Contract contract) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contracts.csv", true));
            bufferedWriter.write(contract.toString());
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Something Went Wrong");
        }
    }
}
