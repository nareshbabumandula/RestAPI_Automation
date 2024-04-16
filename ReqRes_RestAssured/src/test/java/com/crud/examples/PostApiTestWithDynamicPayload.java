package com.crud.examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class PostApiTestWithDynamicPayload
{

    @Test
    public void testPostApiWithDynamicJson() {
        // Set base URI for the API
        RestAssured.baseURI = "https://example.com/api";

        // Generate unique values
        String uniqueId = UUID.randomUUID().toString();
        String dynamicValue = "dynamic_" + uniqueId; // Example of dynamic value generation

        // Create JSON payload with dynamic values
        String jsonPayload = "{"
                + "\"id\": \"" + dynamicValue + "\","
                + "\"name\": \"John Doe\","
                + "\"age\": 30"
                + "}";

        // Send POST request with the dynamically generated JSON payload
        Response response = given()
                .header("Content-Type", "application/json")
                .body(jsonPayload)
                .post("/resource");

        // Validate response
        response.then().statusCode(200); // Assuming successful response code is 200
        // Add more validation as needed
    }
}
