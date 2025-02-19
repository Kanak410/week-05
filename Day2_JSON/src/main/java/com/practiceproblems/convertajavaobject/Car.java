package com.practiceproblems.convertajavaobject;
import org.json.JSONObject;
public class Car {

    public static void main(String[] args) {


    JSONObject jobj=new JSONObject();
        jobj.put("name","Creta");
        jobj.put("model","EX 1.5 Diesel");
        jobj.put("color","Black");
        jobj.put("Type","Fuel");
        System.out.println(jobj.toString());
    }



}
