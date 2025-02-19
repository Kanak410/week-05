package com.handsonpractice.convertCSVdata;


import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.List;
import java.util.Map;

public class CsvToJsonConverter {
    public static void main(String[] args) throws Exception {
        File csvFile = new File("D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\convertCSVdata\\data.csv");

        // Create a CsvMapper instance
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader(); // Read CSV header

        // Read CSV file into List of Maps
        MappingIterator<Map<String, String>> mappingIterator =
                csvMapper.readerFor(Map.class).with(csvSchema).readValues(csvFile);
        List<Map<String, String>> list = mappingIterator.readAll();

        // Convert to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);

        System.out.println("Converted JSON:");
        System.out.println(json);
    }
}

