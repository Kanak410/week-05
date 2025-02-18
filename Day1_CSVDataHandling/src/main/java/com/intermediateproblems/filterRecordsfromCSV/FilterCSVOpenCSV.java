package com.intermediateproblems.filterRecordsfromCSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilterCSVOpenCSV {
    public static void main(String[] args) {
        String path = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\intermediateproblems\\filterRecordsfromCSV\\students.csv";

        // Check if the file exists before processing
        if (!Files.exists(Paths.get(path))) {
            System.out.println("Error: File not found at " + path);
            return;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();

            if (line == null) { // Check if the file is empty
                System.out.println("Error: The CSV file is empty!");
                return;
            }

            String[] headers = line.split(",");
            if (headers.length < 4) {
                System.out.println("Error: CSV file does not have the correct format!");
                return;
            }

            // Print headers
            System.out.printf("%-10s%-20s%-5s%-5s%n", headers[0], headers[1], headers[2], headers[3]);

            // Read and filter student records
            boolean found = false;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length < 4) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                try {
                    int marks = Integer.parseInt(values[3].trim());

                    if (marks > 80) {
                        System.out.printf("%-10s%-20s%-5s%-5s%n", values[0], values[1], values[2], values[3]);
                        found = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid marks: " + values[3]);
                }
            }

            if (!found) {
                System.out.println("No students scored above 80.");
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
