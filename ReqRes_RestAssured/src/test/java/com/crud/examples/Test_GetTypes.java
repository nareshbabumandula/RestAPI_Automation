package com.crud.examples;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class Test_GetTypes {

	public static void main(String[] args) {
		// 1. Basic GET Request:
		Response response = given()
				.when()
				.get("https://api.example.com/resource");
		response.then().statusCode(200);
		response.then().assertThat().body("key1", equalTo("value1"));
		response.then().assertThat().body("items", hasSize(3));
		response.then().header("Content-Type", "application/json; charset=UTF-8");
		response.then().time(lessThan(5000L)); // Response time less than 5 seconds
		response.then().log().all(); // Log the entire response

		response.then()
		.statusCode(200)
		.body("key1", equalTo("value1"))
		.body("items", hasSize(3));

		// i. Using Matchers (Hamcrest Matchers):
		response.then()
		.body("key1", equalTo("value1"))
		.body("key2", hasItems("item1", "item2"))
		.body("key3", is(notNullValue()));

		// ii. JSONPath Expressions:JSONPath allows you to navigate and assert specific elements in the JSON response.
		response.then()
		.body("data[0].name", equalTo("John"))
		.body("data.size()", equalTo(3));

        // iii. Using JsonPath Class:RestAssured provides a JsonPath class to make it easy to parse and validate JSON responses programmatically.
		JsonPath jsonPath = response.jsonPath();
		//assertThat(jsonPath.getString("key1"), equalTo("value1"));

		
		// 2. GET Request with Query Parameters:
		Response response2 = given()
				.queryParam("param1", "value1")
				.queryParam("param2", "value2")
				.when()
				.get("https://api.example.com/resource");

		//3. Path Parameters in GET Request:
		Response response3 = given()
				.pathParam("id", 123)
				.when()
				.get("https://api.example.com/resource/{id}");

		// 4. Specifying Headers in GET Request:
		Response response4 = given()
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer <token>")
				.when()
				.get("https://api.example.com/resource");
	}









}
