package com.advancedProblems.DetectDuplicatesinaCSVFile;


import java.io.*;
import java.util.*;

public class DetectDuplicatesCSV {
    public static void main(String[] args) {
        String filePath = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\advancedProblems\\DetectDuplicatesinaCSVFile\\students.csv";

        Map<String, List<String>> recordMap = new HashMap<>();
        Set<String> duplicateIds = new HashSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Read header
            if (line == null) {
                System.out.println("Error: The file is empty!");
                return;
            }

            System.out.println("Duplicate Records Found:");
            System.out.println(line); // Print header

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length < 2) {
                    System.out.println("Skipping invalid row: " + line);
                    continue;
                }

                String id = data[0];

                // Check if ID already exists
                if (recordMap.containsKey(id)) {
                    duplicateIds.add(id); // Mark ID as duplicate
                }

                // Store record in the map
                recordMap.computeIfAbsent(id, k -> new ArrayList<>()).add(line);
            }

            // Print duplicate records
            for (String id : duplicateIds) {
                for (String record : recordMap.get(id)) {
                    System.out.println(record);
                }
            }

            if (duplicateIds.isEmpty()) {
                System.out.println("No duplicate records found.");
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}


