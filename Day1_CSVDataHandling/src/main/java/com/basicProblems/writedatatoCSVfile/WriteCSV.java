package com.basicProblems.writedatatoCSVfile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\basicProblems\\writedatatoCSVfile\\employees.csv";
        writeCSV(filePath);
    }

    public static void writeCSV(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Write header
            writer.write("ID,Name,Department,Salary");
            writer.newLine();

            // Write employee records
            writer.write("101,John Doe,IT,75000");
            writer.newLine();
            writer.write("102,Jane Smith,HR,68000");
            writer.newLine();
            writer.write("103,Robert Brown,Finance,72000");
            writer.newLine();
            writer.write("104,Emily Davis,Marketing,70000");
            writer.newLine();
            writer.write("105,Michael Johnson,Engineering,80000");
            writer.newLine();

            System.out.println("CSV file created successfully: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
