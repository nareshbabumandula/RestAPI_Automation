package com.restassured.interview;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class BookApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:8080"; // Set your API base URI
        RestAssured.basePath = "/api/books"; // Set your API base path
    }

    @Test(priority = 1)
    public void testGetAllBooks() {
        given()
            .when()
                .get()
            .then()
                .statusCode(200)
                .body("size()", greaterThan(0)); // Assuming there's at least one book
    }

    @Test(priority = 2)
    public void testGetSingleBook() {
        given()
            .pathParam("bookId", 1)
            .when()
                .get("/{bookId}")
            .then()
                .statusCode(200)
                .body("title", equalTo("Book 1"))
                .body("author", equalTo("Author 1"));
    }

    @Test(priority = 3)
    public void testCreateBook() {
        given()
            .contentType(ContentType.JSON)
            .body("{\"title\":\"New Book\",\"author\":\"New Author\"}")
            .when()
                .post()
            .then()
                .statusCode(201)
                .body("message", equalTo("Book added successfully"))
                .body("book.title", equalTo("New Book"))
                .body("book.author", equalTo("New Author"));
    }

    @Test(priority = 4)
    public void testUpdateBook() {
        given()
            .contentType(ContentType.JSON)
            .pathParam("bookId", 1)
            .body("{\"title\":\"Updated Book\",\"author\":\"Updated Author\"}")
            .when()
                .put("/{bookId}")
            .then()
                .statusCode(200)
                .body("message", equalTo("Book updated successfully"))
                .body("book.title", equalTo("Updated Book"))
                .body("book.author", equalTo("Updated Author"));
    }

    @Test(priority = 5)
    public void testDeleteBook() {
        given()
            .pathParam("bookId", 2)
            .when()
                .delete("/{bookId}")
            .then()
                .statusCode(200)
                .body("message", equalTo("Book deleted successfully"));
    }
}
