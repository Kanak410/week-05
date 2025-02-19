package com.handsonpractice.convertlist;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Arrays;
import java.util.List;
public class ListToJSON {
    public static void main(String[] args) throws Exception {

        List<Person> people = Arrays.asList(
                new Person("Kanak Rajput", 27),
                new Person("Amit Sharma", 24),
                new Person("Neha Verma", 30)
        );


        ObjectMapper objectMapper = new ObjectMapper();

        String jsonArray = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(people);

        System.out.println(jsonArray);
    }
}

