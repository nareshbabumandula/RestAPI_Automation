package com.crud.examples;

import io.restassured.RestAssured;

public class SerializationExample {
    public static void main(String[] args) {
        // Base URL of the Reqres API
        RestAssured.baseURI = "https://reqres.in/api";

        // Create a CreateUser object
        CreateUser user = new CreateUser();
        user.setName("Nikhila");
        user.setJob("QA Engineer");

        // Serialize the User object to JSON
        String jsonBody = RestAssured.given()
                .contentType("application/json")
                .body(user)
                .when()
                .post("/users")
                .then()
                .extract()
                .asString();

        System.out.println("Serialized JSON: " + jsonBody);
       
    }
}

