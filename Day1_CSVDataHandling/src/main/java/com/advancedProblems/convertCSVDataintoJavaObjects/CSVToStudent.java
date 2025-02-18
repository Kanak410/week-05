package com.advancedProblems.convertCSVDataintoJavaObjects;

import java.io.*;
import java.util.*;

public class CSVToStudent {

    // Define a Student class
    static class Student {
        private int id;
        private String name;
        private int age;
        private double marks;

        // Constructor to initialize Student object
        public Student(int id, String name, int age, double marks) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.marks = marks;
        }

        // Override toString() method for printing student details
        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Marks: " + marks;
        }
    }

    public static void main(String[] args) {
        String filePath = "D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\advancedProblems\\convertCSVDataintoJavaObjects\\students.csv";
        List<Student> studentList = new ArrayList<>(); // List to store student objects

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = bufferedReader.readLine(); // Read the header line

            if (line != null) {
                // Process the header line
                String[] headers = line.split(",");
                System.out.printf("%-10s%-20s%-5s%-5s%n", headers[0], headers[1], headers[2], headers[3]); // Print headers

                // Read student data lines
                while ((line = bufferedReader.readLine()) != null) {
                    line = line.trim(); // Remove leading/trailing spaces

                    if (line.isEmpty()) {
                        continue; // Skip empty lines
                    }

                    String[] data = line.split(",");

                    if (data.length != 4) {
                        System.out.println("Skipping invalid row: " + line);
                        continue;
                    }

                    try {
                        int id = Integer.parseInt(data[0].trim());
                        String name = data[1].trim();
                        int age = Integer.parseInt(data[2].trim());
                        double marks = Double.parseDouble(data[3].trim());

                        Student student = new Student(id, name, age, marks);
                        studentList.add(student);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping row with invalid number format: " + line);
                    }
                }
            }

            // Print the list of student objects
            System.out.println("\nStudent records:");
            for (Student student : studentList) {
                System.out.println(student);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
