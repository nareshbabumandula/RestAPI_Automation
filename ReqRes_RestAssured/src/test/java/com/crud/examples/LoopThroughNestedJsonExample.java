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
        RestAssured.baseURI = "https://reqres.in";

        // Make the API request and get the response
        Response response = RestAssured.get("/api/users?page=2");

        // Parse the response body as a JSON object
        JSONObject jsonObject = new JSONObject(response.getBody().asString());

        // Get the "users" JSON array from the response
        //JSONArray usersArray = jsonObject.getJSONObject("data").getJSONArray("id");
        JSONArray usersArray = jsonObject.getJSONArray("data");

        // Loop through the "users" array and fetch required data
        for (int i = 0; i < usersArray.length(); i++) {
            JSONObject userObject = usersArray.getJSONObject(i);
            int id = userObject.getInt("id");
            String firstname = userObject.getString("first_name");
            String lastName = userObject.getString("last_name");
            String email = userObject.getString("email");
            
            // Print the fetched data
            System.out.println("User " + (i + 1) + ":");
            System.out.println("ID: " + id);
            System.out.println("First Name: " + firstname);
            System.out.println("Last Name: " + lastName);
            System.out.println("Email: " + email);
            System.out.println();
        }
    }
}
