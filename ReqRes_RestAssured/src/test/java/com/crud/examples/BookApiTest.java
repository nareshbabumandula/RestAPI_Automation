package com.crud.examples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookApiTest {

    private static final String BASE_URL = "YOUR_BASE_URL";
    private static final String USERNAME = "YOUR_USERNAME";
    private static final String PASSWORD = "YOUR_PASSWORD";

    private static String authToken;

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = BASE_URL;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        // Obtain authentication token
        authToken = given()
                .contentType(ContentType.JSON)
                .body("{ \"username\": \"" + USERNAME + "\", \"password\": \"" + PASSWORD + "\" }")
                .when()
                .post("/authenticate")
                .then()
                .statusCode(200)
                .extract().jsonPath().getString("token");
    }

    @Test
    public void createBook() {
        // Define request payload
        Map<String, Object> bookPayload = new HashMap<>();
        bookPayload.put("title", "Sample Book");
        bookPayload.put("author", "John Doe");

        // Perform POST request to create a book
        Response response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + authToken)
                .body(bookPayload)
                .when()
                .post("/books")
                .then()
                .statusCode(201)
                .extract().response();

        // Validate response
        String bookId = response.jsonPath().getString("id");
        Assert.assertNotNull(bookId);
    }

    @Test(dependsOnMethods = "createBook")
    public void getBook() {
        // Perform GET request to retrieve the created book
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + authToken)
                .when()
                .get("/books/{id}", "BOOK_ID")  // Replace "BOOK_ID" with the actual book ID
                .then()
                .statusCode(200)
                .body("title", equalTo("Sample Book"))
                .body("author", equalTo("John Doe"));
    }

    @Test(dependsOnMethods = "getBook")
    public void updateBook() {
        // Define request payload for updating the book
        Map<String, Object> updatePayload = new HashMap<>();
        updatePayload.put("title", "Updated Book Title");

        // Perform PUT request to update the book
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + authToken)
                .body(updatePayload)
                .when()
                .put("/books/{id}", "BOOK_ID")  // Replace "BOOK_ID" with the actual book ID
                .then()
                .statusCode(200);

        // Perform GET request to verify the update
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + authToken)
                .when()
                .get("/books/{id}", "BOOK_ID")  // Replace "BOOK_ID" with the actual book ID
                .then()
                .statusCode(200)
                .body("title", equalTo("Updated Book Title"));
    }

    @Test(dependsOnMethods = "updateBook")
    public void deleteBook() {
        // Perform DELETE request to delete the book
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + authToken)
                .when()
                .delete("/books/{id}", "BOOK_ID")  // Replace "BOOK_ID" with the actual book ID
                .then()
                .statusCode(204);

        // Perform GET request to verify the deletion (should return 404)
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + authToken)
                .when()
                .get("/books/{id}", "BOOK_ID")  // Replace "BOOK_ID" with the actual book ID
                .then()
                .statusCode(404);
    }
}

