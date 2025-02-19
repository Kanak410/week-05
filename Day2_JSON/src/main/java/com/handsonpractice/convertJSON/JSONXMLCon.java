package com.handsonpractice.convertJSON;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JSONXMLCon  {
    public static void main(String[] args) throws IOException {
        // Create ObjectMapper for JSON
        ObjectMapper objectMapper = new ObjectMapper();

        // Read JSON file
        File jsonFile = new File("D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\convertJSON\\data.json");
        JsonNode jsonNode = objectMapper.readTree(jsonFile);

        // Convert JSON to XML
        XmlMapper xmlMapper = new XmlMapper();
        String xmlData = xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonNode);

        // Print XML data
        System.out.println("Converted XML:\n" + xmlData);

        // Save XML to a file
        File xmlFile = new File("D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\convertJSON\\data.xml");
        xmlMapper.writeValue(xmlFile, jsonNode);

        System.out.println(" JSON successfully converted to XML and saved to file!");
    }
}

