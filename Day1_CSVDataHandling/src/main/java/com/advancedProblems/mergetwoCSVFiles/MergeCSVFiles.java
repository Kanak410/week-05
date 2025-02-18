package com.advancedProblems.mergeCSVFiles;

import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\advancedProblems\\mergetwoCSVFiles\\students1.csv";
        String file2 = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\advancedProblems\\mergetwoCSVFiles\\students2.csv";
        String outputFile = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\advancedProblems\\mergetwoCSVFiles\\merged_students.csv";

        Map<String, String[]> studentMap = new HashMap<>();

        // Read students1.csv (ID, Name, Age)
        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            String line = br.readLine(); // Read header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 3) {
                    System.out.println("Skipping invalid row in students1.csv: " + line);
                    continue;
                }
                studentMap.put(data[0], new String[]{data[1], data[2], "", ""}); // ID -> [Name, Age, Marks, Grade]
            }
        } catch (IOException e) {
            System.out.println("Error reading students1.csv: " + e.getMessage());
        }

        // Read students2.csv (ID, Marks, Grade) and merge with existing data
        try (BufferedReader br = new BufferedReader(new FileReader(file2))) {
            String line = br.readLine(); // Read header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 3) {
                    System.out.println("Skipping invalid row in students2.csv: " + line);
                    continue;
                }
                if (studentMap.containsKey(data[0])) {
                    studentMap.get(data[0])[2] = data[1]; // Add Marks
                    studentMap.get(data[0])[3] = data[2]; // Add Grade
                } else {
                    studentMap.put(data[0], new String[]{"", "", data[1], data[2]}); // Missing name & age
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading students2.csv: " + e.getMessage());
        }

        // Write merged data to merged_students.csv
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
            bw.write("ID,Name,Age,Marks,Grade"); // Header
            bw.newLine();
            for (Map.Entry<String, String[]> entry : studentMap.entrySet()) {
                String[] values = entry.getValue();
                bw.write(entry.getKey() + "," + values[0] + "," + values[1] + "," + values[2] + "," + values[3]);
                bw.newLine();
            }
            System.out.println("CSV files merged successfully into " + outputFile);
        } catch (IOException e) {
            System.out.println("Error writing merged_students.csv: " + e.getMessage());
        }
    }
}

