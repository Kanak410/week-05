package com.practiceproblems.convertalist;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;

public class ConvertListToJson {
    public static void main(String[] args) {
        try {
            // Create a list of objects
            List<Person> people = Arrays.asList(
                    new Person("kanak", 21),
                    new Person("ayan", 21),
                    new Person("sakshi", 21)
            );

            // Convert list to JSON array
            ObjectMapper object = new ObjectMapper();
            String jsonArray = object.writeValueAsString(people);

            System.out.println(jsonArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

