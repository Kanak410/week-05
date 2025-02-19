package com.handsonpractice.readJSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

public class ReadAndPrintJSON {
    public static void main(String[] args) throws Exception {

        File file = new File("D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\readJSON\\data.json");

        // Create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();

        // Read JSON file
        JsonNode jsonNode = objectMapper.readTree(file);

        // Print keys and values
        printJson(jsonNode, "");
    }

    private static void printJson(JsonNode node, String parentKey) {
        if (node.isObject()) {
            // Iterate through object fields
            Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> field = fields.next();
                printJson(field.getValue(), parentKey + field.getKey());
            }
        } else if (node.isArray()) {
            // Iterate through array elements
            for (int i = 0; i < node.size(); i++) {
                printJson(node.get(i), parentKey + "[" + i + "]");
            }
        } else {
            // Print key-value pair
            System.out.println(parentKey + " : " + node.asText());
        }
    }
}

