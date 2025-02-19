package com.practiceproblems.mergetwoJSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
public class Merge {
    public static void main(String[] args) {
        try{
            ObjectMapper obj=new ObjectMapper();
            String info="{\"name\": \"kanak rajput\",\n" +
                    "\n" +
                    "\"age\": 22,\n" +
                    "\"city\": \"Itarsi\"}";
            String contact="{\n" +

                    "  \"email\": \"rajputkanak078@gmail.com\",\n" +
                    "  \"phone no\": 566686787\n" +
                    "}";
            ObjectNode node1=(ObjectNode) obj.readTree(info);
            ObjectNode node2= (ObjectNode) obj.readTree(contact);
            node1.setAll(node2);
            String mergejson=obj.writerWithDefaultPrettyPrinter().writeValueAsString(node1);
            System.out.println(mergejson);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
