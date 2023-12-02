package com.crud.examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiAuthenticationExample {

    public static void main(String[] args) {
        // Set the base URI for your API
        RestAssured.baseURI = "https://api.example.com";

        // Basic Authentication
        Response basicAuthResponse = RestAssured.given()
                .auth()
                .basic("username", "password")
                .get("/endpoint");

        // Digest Authentication
        Response digestAuthResponse = RestAssured.given()
                .auth()
                .digest("username", "password")
                .get("/endpoint");

        // OAuth 2.0 Authentication
        Response oauth2Response = RestAssured.given()
                .auth()
                .oauth2("your_access_token")
                .get("/endpoint");

        // Bearer Token Authentication
        Response bearerTokenResponse = RestAssured.given()
                .header("Authorization", "Bearer your_access_token")
                .get("/endpoint");

        // Custom Authentication (e.g., API Key)
        Response customAuthResponse = RestAssured.given()
                .header("X-API-Key", "your_api_key")
                .get("/endpoint");

        // Print the responses or perform further validation
        System.out.println("Basic Auth Response: " + basicAuthResponse.asString());
        System.out.println("Digest Auth Response: " + digestAuthResponse.asString());
        System.out.println("OAuth 2.0 Response: " + oauth2Response.asString());
        System.out.println("Bearer Token Response: " + bearerTokenResponse.asString());
        System.out.println("Custom Auth Response: " + customAuthResponse.asString());
    }
}
