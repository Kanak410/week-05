package com.handsonpractice.iPLandCensorAnalyzer;
import com.fasterxml.jackson.databind.JsonNode;
public class Main {
    public static void main(String[] args)throws Exception {
        final String csvPath = "D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\iPLandCensorAnalyzer\\ipl_matches.csv";
        final String modifiedCsvPath = "D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\iPLandCensorAnalyzer\\censored_ipl_matches.csv";
        CsvCensor.censorCsvContent(csvPath,modifiedCsvPath);

        final String jsonPath = "D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\iPLandCensorAnalyzer\\ipl_matches.json";
        final String jsonPathModified ="D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\iPLandCensorAnalyzer\\censored_ipl_matches.json";
        JsonCensor.censorJsonContent(jsonPath,jsonPathModified);
    }
}

