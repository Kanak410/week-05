package com.advancedProblems.encryptandDecryptCSVData;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DecryptCSV {
    public static void main(String[] args) {
        String filePath = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\advancedProblems\\encryptandDecryptCSVData\\employees_encrypted.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Read header
            System.out.println(line); // Print header

            while ((line = reader.readLine()) != null) {
                String[] details = line.split(",");

                String decryptedSalary = AESUtil.decrypt(details[3]);
                String decryptedEmail = AESUtil.decrypt(details[4]);

                System.out.printf("%s, %s, %s, %s, %s%n", details[0], details[1], details[2], decryptedSalary, decryptedEmail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
