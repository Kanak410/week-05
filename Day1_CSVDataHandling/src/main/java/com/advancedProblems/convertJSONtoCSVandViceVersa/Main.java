package com.advancedProblems.convertJSONtoCSVandViceVersa;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void json2Csv()throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\advancedProblems\\convertJSONtoCSVandViceVersa\\employee.csv" +
                ".json");

        // Read Json and map to person class

        List<Person> personList = objectMapper.readValue(file, new TypeReference<List<Person>>() {
        });

        for(Person person: personList){
            System.out.println(person.toString());
        }

        File file2write = new File("/Users/siddhu/Desktop/cg-tut/Week5/Day01-CsvDataHandling/src/main/resources" +
                "/employees.csv");
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2write))){
            String line;
            bufferedWriter.write("ID,Name,Age,Email,IsActive");
            bufferedWriter.newLine();
            for(Person person: personList){
                String id = String.valueOf(person.getId());
                String name = person.getName();
                String age = String.valueOf(person.getAge());
                String email = String.valueOf(person.getEmail());
                String isActive = String.valueOf(person.isIs_active());


                line = id+","+name+","+age+","+email+","+isActive;
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        }
    }
    public static void csv2Json()throws Exception{

        ObjectMapper objectMapper = new ObjectMapper();

        File csvFile = new File("D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\advancedProblems\\convertJSONtoCSVandViceVersa\\employees.csv");
        File jsonFile = new File("D:\\week-05\\Day1_CSVDataHandling\\src\\main\\java\\com\\advancedProblems\\convertJSONtoCSVandViceVersa\\employees_from_csv.json"); // New JSON file

        List<Person> personList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile))) {
            String line = bufferedReader.readLine(); // Skip header line
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) { // Ensure all 5 values are present
                    try {
                        int id = Integer.parseInt(data[0]);
                        String name = data[1];
                        int age = Integer.parseInt(data[2]);
                        String email = data[3];
                        boolean isActive = Boolean.parseBoolean(data[4]);

                        Person person = new Person(); // Create a new Person object
                        person.setId(id);
                        person.setName(name);
                        person.setAge(age);
                        person.setEmail(email);
                        person.setIs_active(isActive);

                        personList.add(person);
                    } catch (NumberFormatException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        objectMapper.writeValue(jsonFile, personList);
        System.out.println("CSV to JSON conversion complete.");
    }


    public static void main(String[] args) throws Exception{
        json2Csv();
        csv2Json();

    }
}
