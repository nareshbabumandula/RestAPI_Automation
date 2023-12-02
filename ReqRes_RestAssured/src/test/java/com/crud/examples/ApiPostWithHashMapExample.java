package com.crud.examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ApiPostWithHashMapExample {

    public static void main(String[] args) {
        // Set the base URI for your API
        RestAssured.baseURI = "https://api.example.com";

        // Create the request payload as a HashMap
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "John Doe");
        requestBody.put("email", "john.doe@example.com");
        requestBody.put("age", 30); // You can add more fields as needed

        // Make the POST request and get the response
        Response response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/endpoint");

        // Print the response from the POST request
        System.out.println(response.asString());
    }
}