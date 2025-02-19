package com.handsonpractice.filterJSONdata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
public class FilterUsers {
    public static void main(String[] args) throws Exception {

        File file = new File("D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\filterJSONdata\\user.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonArray = objectMapper.readTree(file);

        // Check if JSON is an array
        if (jsonArray.isArray()) {
            for (JsonNode user : jsonArray) {
                // Fix key name by ensuring lowercase "age"
                if (user.has("age") && user.get("age").asInt() > 25) {
                    System.out.println(user.toPrettyString());
                }
            }
        }
    }

}
