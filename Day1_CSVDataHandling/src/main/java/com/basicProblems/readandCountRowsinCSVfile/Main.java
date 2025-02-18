package com.basicProblems.readandCountRowsinCSVfile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static int countRows(String filePath) {
        int rowCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstRow = true;
            while ((line = br.readLine()) != null) {
                if (isFirstRow) { // Skip header row
                    isFirstRow = false;
                    continue;
                }
                rowCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
    public static void main(String[] args) {
        String path = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\basicProblems\\readandCountRowsinCSVfile\\read.csv";
        System.out.println("Number of records: " + countRows(path));
    }



}
