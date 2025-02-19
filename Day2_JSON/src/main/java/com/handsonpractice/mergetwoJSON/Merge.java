package com.handsonpractice.mergetwoJSON;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class Merge {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        File file1 = new File("D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\mergetwoJSON\\file1.json");
        JsonNode jsonNode1 = objectMapper.readTree(file1);

        // Load second JSON file
        File file2 = new File("D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\mergetwoJSON\\file2.json");
        JsonNode jsonNode2 = objectMapper.readTree(file2);

        // Merge JSON objects
        ObjectNode mergedJson = objectMapper.createObjectNode();
        mergedJson.setAll((ObjectNode) jsonNode1);
        mergedJson.setAll((ObjectNode) jsonNode2);

        // Print merged JSON
        System.out.println("Merged JSON:\n" + objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(mergedJson));

        // Save to a new JSON file
        File mergedFile = new File("D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\mergetwoJSON\\merged.json");
        objectMapper.writeValue(mergedFile, mergedJson);

        System.out.println("Merged JSON saved successfully!");
    }
}

