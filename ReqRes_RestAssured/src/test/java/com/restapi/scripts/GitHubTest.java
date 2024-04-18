package com.restapi.scripts;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GitHubTest {
	
	public static RequestSpecification requestSpec;

	@BeforeClass
	public static void setup() {
		RestAssured.baseURI = "https://api.github.com";
		
		requestSpec = new RequestSpecBuilder()
				.setBaseUri("https://api.github.com")
				.addHeader("Authorization", "Basic " + RestAssured.basic("qaautotestuser", "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"))
				.setContentType("application/json")
				.build();
	}

	@Test
	public void testCreateRepository() {
		String requestBody = "{\"name\":\"TestRepository17\","
				+ "\"description\":\"This is your first repo created via RestAssured!\","
				+ "\"homepage\":\"https://github.com\","
				+ "\"private\":false,\"is_template\":true}";
		
		given()
			.auth().preemptive().basic("qaautotestuser", "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")
			.contentType("application/json")
			.body(requestBody)
		.when()
			.post("/user/repos")
		.then()
			.statusCode(201)
			.body("name", equalTo("TestRepository17"))
			.body("description", equalTo("This is your first repo created via RestAssured!"));
	}
	
	@Test
	public void createRepository() {
		String requestBody = "{\"name\":\"TestRepository18\","
				+ "\"description\":\"This is your first repo created via RestAssured!\","
				+ "\"homepage\":\"https://github.com\","
				+ "\"private\":false,\"is_template\":true}";
		
		Response response = given()
				.spec(requestSpec)
				.body(requestBody)
				.when()
				.post("/user/repos")
				.then()
				.extract().response();
		
		response.then().statusCode(201);
				
	}
}
