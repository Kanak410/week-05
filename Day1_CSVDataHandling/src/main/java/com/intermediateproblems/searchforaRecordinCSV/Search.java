package com.intermediateproblems.searchforaRecordinCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Search {
    public static void main(String[] args) {
        String path = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\intermediateproblems\\searchforaRecordinCSV\\employees.csv";
        String searchName = "Siddharth Joshi"; // Name to search

        // Check if file exists before processing
        if (!Files.exists(Paths.get(path))) {
            System.out.println("Error: File not found at " + path);
            return;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();

            // Check if the file is empty
            if (line == null) {
                System.out.println("Error: The CSV file is empty!");
                return;
            }

            String[] headers = line.split(",");
            if (headers.length < 3) {
                System.out.println("Error: CSV file does not have the correct format!");
                return;
            }

            // Print table headers
            System.out.printf("%-20s%-20s%-10s%n", headers[0], headers[1], headers[2]);

            boolean found = false;

            while ((line = bufferedReader.readLine()) != null) {
                String[] columns = line.split(",");

                if (columns.length < 3) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                String name = columns[1].trim(); // Assuming Name is in the second column

                if (name.equalsIgnoreCase(searchName)) {
                    System.out.printf("%-20s%-20s%-10s%n", columns[0], columns[1], columns[2]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Employee not found!");
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
