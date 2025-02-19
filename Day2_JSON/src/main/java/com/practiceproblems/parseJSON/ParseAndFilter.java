package com.practiceproblems.parseJSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ParseAndFilter {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\practiceproblems\\parseJSON\\rat.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(file);


        if (jsonNode.isArray()) {
            for (JsonNode element : jsonNode) {

                if (element.has("Age") && element.get("Age").asInt() > 25) {
                    System.out.println(element.toPrettyString());
                }
            }
        } else {
            System.out.println("The JSON is not an array.");
        }
    }
}
