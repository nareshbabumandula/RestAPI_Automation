package com.crud.examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class PostRequestExampleWithAllAuthenticationTypes {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.example.com"; // Replace with your API base URL
        RestAssured.port = 443; // Set the port if necessary
    }

    @Test
    public void postRequestWithDifferentAuthAndValidations() {
        // Define the request body (if needed)
        String requestBody = "{ \"key\": \"value\" }";

        // Basic Authentication
        Response basicAuthResponse = RestAssured.given()
            .auth().basic("username", "password")
            .contentType(ContentType.JSON)
            .body(requestBody)
            .post("/endpoint");

        // Digest Authentication
        Response digestAuthResponse = RestAssured.given()
            .auth().digest("username", "password")
            .contentType(ContentType.JSON)
            .body(requestBody)
            .post("/endpoint");

        // OAuth2 Authentication
        Response oauth2Response = RestAssured.given()
            .auth().oauth2("your_oauth2_token")
            .contentType(ContentType.JSON)
            .body(requestBody)
            .post("/endpoint");

        // Bearer Token Authentication
        String bearerToken = "your_bearer_token";
        Response bearerTokenResponse = RestAssured.given()
            .header("Authorization", "Bearer " + bearerToken)
            .contentType(ContentType.JSON)
            .body(requestBody)
            .post("/endpoint");

        // Validate the responses
        basicAuthResponse.then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("key", equalTo("expected_value"));

        digestAuthResponse.then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("key", equalTo("expected_value"));

        oauth2Response.then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("key", equalTo("expected_value"));

        bearerTokenResponse.then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("key", equalTo("expected_value"));

        // Extract cookies
        String cookieValue = basicAuthResponse.getCookie("your_cookie_name");

        // Set request headers
        RestAssured.given()
            .header("Header1", "Value1")
            .header("Header2", "Value2")
            .cookie("your_cookie_name", cookieValue)
            .contentType(ContentType.JSON)
            .body(requestBody)
            .post("/another_endpoint");
    }
}
