package com.authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateRepository {

	@Test
	public void createRepository() {

		RestAssured.baseURI = "https://api.github.com"; 
		// JSONObject is a class that represents a Simple JSON. 
		// We can add Key - Value pairs using the put method 
		JSONObject requestParams = new JSONObject(); 
		requestParams.put("name", "TestProject_111");
		requestParams.put("description", "Test Project created by RestAssured");
		requestParams.put("homepage", "https://api.github.com");
		requestParams.put("private", false);
		requestParams.put("has_issues", true);
		requestParams.put("has_projects", true);
		RequestSpecification request = RestAssured.given().auth().preemptive().basic("nareshbabumandula", "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")
		.header("Content-Type", "application/json")
		.body(requestParams.toJSONString()); // Post the request and check the response
		Response response = request.post("/user/repos"); 
		System.out.println("The status received: " + response.statusLine());

	}
}
