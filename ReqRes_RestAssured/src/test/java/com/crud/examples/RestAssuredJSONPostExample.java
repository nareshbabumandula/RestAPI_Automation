package com.crud.examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class RestAssuredJSONPostExample {
	public static void main(String[] args) {
		String endpointURL = "https://api.example.com/create";

		// JSON payload
		String jsonPayload = "{ \"name\": \"John Doe\", \"email\": \"john@example.com\", \"age\": 30 }";

		// Send POST request with JSON payload
		RestAssured.given()
		.contentType(ContentType.JSON) // Set content type as JSON
		.body(jsonPayload) // Set JSON payload in the request body
		.post(endpointURL) // Send POST request to the specified endpoint
		.then()
		.statusCode(200); // Assert the expected response status code (if needed)
	}
}
