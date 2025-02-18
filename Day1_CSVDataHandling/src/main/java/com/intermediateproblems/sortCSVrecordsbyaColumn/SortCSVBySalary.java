package com.intermediateproblems.sortCSVrecordsbyaColumn;


import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SortCSVBySalary {
    public static void main(String[] args) {
        String inputFilePath = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\intermediateproblems\\sortCSVrecordsbyaColumn\\employees.csv";

        // Check if the file exists before processing
        if (!Files.exists(Paths.get(inputFilePath))) {
            System.out.println("Error: File not found at " + inputFilePath);
            return;
        }

        List<String[]> records = new ArrayList<>();

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

            // Add headers to the records list
            records.add(headers);

            // Read the rest of the file and add to records
            while ((line = bufferedReader.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns.length < 4) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }
                records.add(columns);
            }

            // Sort the records by salary in descending order
            records.sort((record1, record2) -> {
                try {
                    double salary1 = Double.parseDouble(record1[3]);
                    double salary2 = Double.parseDouble(record2[3]);
                    return Double.compare(salary2, salary1);  // For descending order
                } catch (NumberFormatException e) {
                    return 0;  // In case of invalid salary
                }
            });

            // Print the top 5 highest-paid employees
            System.out.printf("%-10s%-20s%-15s%-10s%n", headers[0], headers[1], headers[2], headers[3]);
            System.out.println("---------------------------------------------------------");

            int count = 0;
            for (int i = 1; i < records.size() && count < 5; i++) {
                String[] record = records.get(i);
                System.out.printf("%-10s%-20s%-15s%-10s%n", record[0], record[1], record[2], record[3]);
                count++;
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

