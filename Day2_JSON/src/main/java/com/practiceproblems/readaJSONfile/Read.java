package com.practiceproblems.readaJSONfile;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class Read {
    public static void main(String[] args) {
        try {
            ObjectMapper obj = new ObjectMapper();

            JsonNode root = obj.readTree(new File("D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\practiceproblems\\readaJSONfile\\data.json"));
            String name = root.get("name").asText();
            String email = root.get("email").asText();
            System.out.println("Name  " + name);
            System.out.println("Email  " + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
