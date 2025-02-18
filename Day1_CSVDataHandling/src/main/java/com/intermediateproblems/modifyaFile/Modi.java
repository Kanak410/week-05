package com.intermediateproblems.modifyaFile;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Modi {
    public static void main(String[] args) {
        String inputFilePath = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\intermediateproblems\\modifyaFile\\employees.csv";
        String outputFilePath = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\intermediateproblems\\modifyaFile\\updated_employees.csv";

        if (!Files.exists(Paths.get(inputFilePath))) {
            System.out.println("Error: File not found at " + inputFilePath);
            return;
        }

        List<String[]> updatedRecords = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath))) {
            String line = bufferedReader.readLine();

            // Check if the file is empty
            if (line == null) {
                System.out.println("Error: The CSV file is empty!");
                return;
            }

            String[] headers = line.split(",");
            if (headers.length < 4) {
                System.out.println("Error: CSV file does not have the correct format!");
                return;
            }

            // Add headers to the updated records list
            updatedRecords.add(headers);

            // Read and process each line
            while ((line = bufferedReader.readLine()) != null) {
                String[] columns = line.split(",");

                if (columns.length < 4) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                // Check if the employee is from IT department
                if ("IT".equalsIgnoreCase(columns[2])) {
                    try {
                        // Increase the salary by 10%
                        double salary = Double.parseDouble(columns[3]);
                        salary *= 1.10;  // Increase by 10%
                        columns[3] = String.format("%.2f", salary);  // Format salary to two decimal places
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid salary value in line: " + line);
                    }
                }

                // Add the updated line to the records list
                updatedRecords.add(columns);
            }

            // Write the updated records to a new CSV file
            writeToCSV(updatedRecords, outputFilePath);
            System.out.println("CSV file updated successfully!");

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    // Method to write the updated records to a new CSV file
    private static void writeToCSV(List<String[]> records, String outputPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            for (String[] record : records) {
                writer.write(String.join(",", record));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing the file: " + e.getMessage());
        }
    }
}
