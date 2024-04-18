package com.restapi.scripts;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class APITest {

	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://reqres.in";
	}
	
	@Test
	public void testCreateUser() {
		String requestBody = "{\"name\": \"naresh\","
				+ "\"job\": \"automation engineer\","
				+ "\"id\": \"111\"}";
		
		given()
			.contentType("application/json")
			.body(requestBody)
		.when()
			.post("/api/users")
		.then()
			.statusCode(201)
			.body("name", equalTo("naresh"))
			.body("job", equalTo("automation engineer"));
	}

}
