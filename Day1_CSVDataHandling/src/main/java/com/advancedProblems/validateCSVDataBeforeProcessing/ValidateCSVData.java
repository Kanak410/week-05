package com.advancedProblems.validateCSVDataBeforeProcessing;


import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String inputFilePath = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\advancedProblems\\validateCSVDataBeforeProcessing\\employees.csv";

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        String phoneRegex = "^\\d{10}$";  // For exactly 10 digits

        // Compile the regex patterns
        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        // Check if the file exists
        if (!Files.exists(Paths.get(inputFilePath))) {
            System.out.println("Error: File not found at " + inputFilePath);
            return;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath))) {
            String line = bufferedReader.readLine();

            // Check if the file is empty
            if (line == null) {
                System.out.println("Error: The CSV file is empty!");
                return;
            }

            String[] headers = line.split(",");
            if (headers.length < 5) {  // Assuming there are at least 5 columns
                System.out.println("Error: CSV file does not have the correct format!");
                return;
            }

            // Read each line of the CSV file
            while ((line = bufferedReader.readLine()) != null) {
                String[] columns = line.split(",");

                // Check if the row has the correct number of columns
                if (columns.length < 5) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                String email = columns[3]; // Assuming email is in the 4th column
                String phone = columns[4]; // Assuming phone number is in the 5th column

                // Validate email and phone number
                boolean isEmailValid = emailPattern.matcher(email).matches();
                boolean isPhoneValid = phonePattern.matcher(phone).matches();

                // Print error messages for invalid rows
                if (!isEmailValid) {
                    System.out.println("Invalid email format: " + email + " in line: " + line);
                }
                if (!isPhoneValid) {
                    System.out.println("Invalid phone number: " + phone + " in line: " + line);
                }

                // If both are valid, process the row (you can add further processing here)
                if (isEmailValid && isPhoneValid) {
                    // Example: just print the valid row
                    System.out.println("Valid row: " + Arrays.toString(columns));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}

