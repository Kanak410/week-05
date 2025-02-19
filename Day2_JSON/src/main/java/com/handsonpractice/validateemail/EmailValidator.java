package com.handsonpractice.validateemail;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;
import java.io.IOException;

public class EmailValidator {
    public static void main(String[] args) throws ProcessingException, IOException {


    ObjectMapper objectMapper = new ObjectMapper();
    JsonNode jsonNode = objectMapper.readTree(new File("D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\validateemail\\schema.json" ));
    JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
    JsonSchema schema = factory.getJsonSchema(jsonNode);

    JsonNode jsonData = objectMapper.readTree(new File("D:\\week-05\\Day2_JSON\\src\\main\\java\\com\\handsonpractice\\validateemail\\data.json" ));
        if(schema.validate(jsonData).isSuccess()){
        System.out.println("Json is valid !!");
    }
        else{
            System.out.println("Invalid Json");}
   }

}
