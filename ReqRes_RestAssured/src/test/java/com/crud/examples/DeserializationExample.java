package com.crud.examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeserializationExample {
    public static void main(String[] args) {
        // Base URL of the Reqres API
        RestAssured.baseURI = "https://reqres.in/api";

        // Send a GET request to retrieve user details (example: user with ID 2)
        Response response = RestAssured.get("/users/2");

        // Deserialize JSON response to a User object
        User user = response.as(User.class);

        // Access the deserialized User object's properties
        System.out.println("User First Name: " + user.getFirst_name());
        System.out.println("User Last Name: " + user.getLast_name());
        // Other properties...

        // Perform assertions or further operations with the deserialized User object
    }
}
