package com.basicProblems.readCSVfileandPrintData;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
        String filePath = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\basicProblems\\readCSVfileandPrintData\\students.csv";
        readAndPrintCSV(filePath);
    }

    public static void readAndPrintCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;

            while ((line = br.readLine()) != null) {
                line = line.trim(); // Remove extra spaces

                if (isHeader) { // Skip the header row
                    isHeader = false;
                    continue;
                }

                if (line.isEmpty()) { // Skip empty lines
                    continue;
                }

                String[] data = line.split(","); // Split CSV values

                if (data.length < 4) { // Check if all columns are present
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                System.out.println("ID: " + data[0] + ", Name: " + data[1] + ", Age: " + data[2] + ", Marks: " + data[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
