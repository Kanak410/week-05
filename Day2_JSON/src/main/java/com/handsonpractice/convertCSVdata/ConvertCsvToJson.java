package com.handsonpractice.convertCSVdata;



import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class ConvertCsvToJson {
    public static void csvToJson(String csvFilePath, String jsonFilePath) throws Exception {
        JSONArray jsonArray = new JSONArray();

        // Use try-with-resources to automatically close the BufferedReader
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFilePath))) {
            // Read the header line
            String headLine = bufferedReader.readLine();
            if (headLine == null) {
                throw new IllegalArgumentException("CSV file is empty.");
            }

            // Split the header into column names
            String[] headers = headLine.split(",");

            // Process each line in the CSV file
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Split the line into columns
                String[] columns = line.split(",");

                // Create a JSON object for the current row
                JSONObject jsonObject = new JSONObject();

                // Add each column to the JSON object
                for (int i = 0; i < headers.length; i++) {
                    String header = headers[i].trim();
                    String value = (i < columns.length) ? columns[i].trim() : ""; // Handle missing values
                    jsonObject.put(header, value);
                }

                // Add the JSON object to the JSON array
                jsonArray.put(jsonObject);
            }
        }

        // Write the JSON array to the output file
        try (FileWriter fileWriter = new FileWriter(jsonFilePath)) {
            fileWriter.write(jsonArray.toString(2)); // Use indentation for pretty-printing
        }
    }

    public static void main(String[] args) {
        String csvFilePath = "D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\convertCSVdata\\data.csv";
        String jsonFilePath = "D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\convertCSVdata\\data.json";

        try {
            csvToJson(csvFilePath, jsonFilePath);
            System.out.println("CSV file successfully converted to JSON.");
        } catch (Exception e) {
            System.err.println("Error converting CSV to JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

