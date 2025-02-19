package com.practiceproblems.validateJSON;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class Valid {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

            // Load JSON data
            JsonNode jsonData = objectMapper.readTree(new File("D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\practiceproblems\\validateJSON\\schema.json"));

            // Load JSON Schema
            JsonNode jsonSchemaNode = objectMapper.readTree(new File("D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\practiceproblems\\validateJSON\\data.json"));

            // Create schema factory and schema instance
            JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonSchema schema = factory.getJsonSchema(jsonSchemaNode);

            // Validate JSON against schema
            ProcessingReport report = schema.validate(jsonData);

            if (report.isSuccess()) {
                System.out.println("JSON is valid!");
            } else {
                System.out.println("JSON is invalid!");
                report.forEach(msg -> System.out.println(msg));
            }

        } catch (IOException | ProcessingException e) {
            e.printStackTrace();
        }
    }
}
