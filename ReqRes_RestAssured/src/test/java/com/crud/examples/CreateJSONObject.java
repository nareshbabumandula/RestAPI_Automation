package com.crud.examples;

import org.json.JSONArray;
import org.json.JSONObject;

public class CreateJSONObject {
    public static void main(String[] args) {
        // Create JSON object
        JSONObject jsonObject = new JSONObject();
        
        // Add key-value pairs to the JSON object
        jsonObject.put("name", "John");
        jsonObject.put("age", 30);
        
        // Create a JSON array for cars
        JSONArray carsArray = new JSONArray();
        carsArray.put("Ford");
        carsArray.put("BMW");
        carsArray.put("Fiat");
        
        // Add the JSON array to the JSON object
        jsonObject.put("cars", carsArray);
        
        // Print the JSON object
        System.out.println(jsonObject.toString());
    }
}
