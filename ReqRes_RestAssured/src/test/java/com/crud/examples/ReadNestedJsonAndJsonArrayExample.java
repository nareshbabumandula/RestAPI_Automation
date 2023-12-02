package com.crud.examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReadNestedJsonAndJsonArrayExample {

// Let's assume the response from the API looks like the following JSON:
//	{
//		  "id": 123,
//		  "name": "John Doe",
//		  "email": "john.doe@example.com",
//		  "address": {
//		    "city": "New York",
//		    "zipcode": "10001"
//		  },
//		  "hobbies": [
//		    "Reading",
//		    "Traveling",
//		    "Cooking"
//		  ]
//		}


    public static void main(String[] args) {
        // Set the base URI for your API
        RestAssured.baseURI = "https://api.example.com";

        // Make the API request and get the response
        Response response = RestAssured.get("/endpoint");

        // Parse and read the nested JSON data
        int id = response.path("id");
        String name = response.path("name");
        String email = response.path("email");
        String city = response.path("address.city");
        String zipcode = response.path("address.zipcode");

        // Parse and read the JSON array data
        String hobby1 = response.path("hobbies[0]");
        String hobby2 = response.path("hobbies[1]");
        String hobby3 = response.path("hobbies[2]");

        // Print the extracted data
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("City: " + city);
        System.out.println("Zipcode: " + zipcode);
        System.out.println("Hobbies: " + hobby1 + ", " + hobby2 + ", " + hobby3);
    }
}
