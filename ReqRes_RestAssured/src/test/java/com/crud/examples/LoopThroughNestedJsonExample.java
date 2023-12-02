package com.crud.examples;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/*{
	  "data": {
	    "users": [
	      {
	        "id": 1,
	        "name": "John Doe",
	        "email": "john.doe@example.com",
	        "address": {
	          "city": "New York",
	          "zipcode": "10001"
	        }
	      },
	      {
	        "id": 2,
	        "name": "Jane Smith",
	        "email": "jane.smith@example.com",
	        "address": {
	          "city": "Los Angeles",
	          "zipcode": "90001"
	        }
	      }
	    ]
	  }
	}
*/

public class LoopThroughNestedJsonExample {

    public static void main(String[] args) {
        // Set the base URI for your API
        RestAssured.baseURI = "https://api.example.com";

        // Make the API request and get the response
        Response response = RestAssured.get("/endpoint");

        // Parse the response body as a JSON object
        JSONObject jsonObject = new JSONObject(response.getBody().asString());

        // Get the "users" JSON array from the response
        JSONArray usersArray = jsonObject.getJSONObject("data").getJSONArray("users");

        // Loop through the "users" array and fetch required data
        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject userObject = usersArray.getJSONObject(i);
            int id = userObject.getInt("id");
            String name = userObject.getString("name");
            String email = userObject.getString("email");
            String city = userObject.getJSONObject("address").getString("city");
            String zipcode = userObject.getJSONObject("address").getString("zipcode");

            // Print the fetched data
            System.out.println("User " + (i + 1) + ":");
            System.out.println("ID: " + id);
            System.out.println("Name: " + name);
            System.out.println("Email: " + email);
            System.out.println("City: " + city);
            System.out.println("Zipcode: " + zipcode);
            System.out.println();
        }
    }
}
