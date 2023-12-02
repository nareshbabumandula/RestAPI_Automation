package com.crud.examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class ApiPutAndResponseToHashMapExample {

    public static void main(String[] args) {
        // Set the base URI for your API
        RestAssured.baseURI = "https://api.example.com";

        // Define the request payload for the PUT request
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "Updated Name");
        requestBody.put("email", "updated.email@example.com");
        requestBody.put("age", 35); // You can add more fields as needed

        // Make the PUT request and get the response
        Response putResponse = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .pathParam("id", 123) // Replace "123" with the actual resource ID
                .when()
                .put("/endpoint/{id}");

        // Get the response body as a HashMap
        Map<String, Object> responseAsHashMap = putResponse.getBody().as(HashMap.class);

        // Print the response HashMap
        System.out.println(responseAsHashMap);
    }
}
