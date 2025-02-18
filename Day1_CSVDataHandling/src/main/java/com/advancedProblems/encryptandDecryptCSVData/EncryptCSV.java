package com.advancedProblems.encryptandDecryptCSVData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EncryptCSV {
    public static void main(String[] args) {
        String filePath = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\advancedProblems\\encryptandDecryptCSVData\\employees_encrypted.csv";

        String[] employees = {
                "101,John Doe,IT,55000,john@example.com",
                "102,Jane Smith,HR,60000,jane@example.com",
                "103,David Wilson,Finance,75000,david@example.com",
                "104,Emma Johnson,IT,80000,emma@example.com",
                "105,Robert Brown,Marketing,50000,robert@example.com"
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Writing header
            writer.write("ID,Name,Department,Salary,Email");
            writer.newLine();

            for (String emp : employees) {
                String[] details = emp.split(",");
                String encryptedSalary = AESUtil.encrypt(details[3]);
                String encryptedEmail = AESUtil.encrypt(details[4]);

                writer.write(details[0] + "," + details[1] + "," + details[2] + "," + encryptedSalary + "," + encryptedEmail);
                writer.newLine();
            }

            System.out.println("CSV file with encrypted data created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
