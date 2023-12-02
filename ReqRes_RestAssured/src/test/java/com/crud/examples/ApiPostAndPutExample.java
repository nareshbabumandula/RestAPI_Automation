package com.crud.examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiPostAndPutExample {

    public static void main(String[] args) {
        // Set the base URI for your API
        RestAssured.baseURI = "https://api.example.com";

        // Define the request payload for the POST request
        String requestBody = "{\"name\": \"John Doe\", \"email\": \"john.doe@example.com\"}";

        // Make the POST request and get the response
        Response postResponse = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/create");

        // Extract the ID from the POST response to use in the PUT request
        int postId = postResponse.path("id");

        // Define the request payload for the PUT request
        String updatedRequestBody = "{\"name\": \"Updated Name\", \"email\": \"updated.email@example.com\"}";

        // Make the PUT request using the extracted ID
        Response putResponse = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(updatedRequestBody)
                .pathParam("id", postId)
                .when()
                .put("/update/{id}");

        // Print the response from the PUT request
        System.out.println(putResponse.asString());
    }
}
