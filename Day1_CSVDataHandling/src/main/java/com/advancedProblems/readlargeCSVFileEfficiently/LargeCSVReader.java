package com.advancedProblems.readlargeCSVFileEfficiently;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {
    public static void processLargeCSV(String filePath, int chunkSize) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int recordCount = 0;

            while ((line = br.readLine()) != null) {
                recordCount++;

                // Process the line (You can add actual processing logic here)

                if (recordCount % chunkSize == 0) {
                    System.out.println("Processed " + recordCount + " records");
                }
            }

            // Print final count if not a multiple of chunkSize
            System.out.println("Total records processed: " + recordCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String filePath = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\advancedProblems\\readlargeCSVFileEfficiently\\large_file.csv";
        int chunkSize = 100;
        processLargeCSV(filePath, chunkSize);
    }
}


