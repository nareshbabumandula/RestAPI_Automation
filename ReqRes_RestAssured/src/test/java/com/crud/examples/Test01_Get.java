package com.crud.examples;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class Test01_Get {

	@Test
	public void test() {
		/**
		 * RestAssured.get()
		 * 1. This method is a static method provided by the RestAssured class
		 * 2. It is used for sending an HTTP GET request without any additional configuration
		 * 3. It is typically used for simple GET requests where no addition customization is needed
		 */
		Response response = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(response.getTime());
		System.out.println(response.statusCode());
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.statusLine());
	
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		JsonPath jsonpath = response.jsonPath();
		String email = jsonpath.get("data.email[0]");
		System.out.println(email);
		
	}

	@Test
	public void test1() {
		/**
		 * RestAssured.given().get()
		 * 1. This is part of given/when/then syntax provided by RestAssured for writing more expressive and readable scripts
		 * 2. The given() method allows you to set up pre-conditions or configurations for your request, such as
		 * headers, parameters or authentication
		 * 3. The get() method is then used to actually perform the HTTP GET request for the pre-conditions are set up.
		 */
		given().get("https://reqres.in/api/users?page=2").
		then().statusCode(200).contentType("application/json")
		.body("data.id[0]", equalTo(7))
		.and().body("data.email[0]", equalTo("michael.lawson@reqres.in"));
	}

	@Test
	public void jsonValidations() {

		//base URI with Rest Assured class
		RestAssured.baseURI = "https://reqres.in";

		//input details
		RequestSpecification reqspec = RestAssured.given();
		//get response
		Response res = reqspec.get("/api/users?page=2");

		//Response body
		ResponseBody b = res.getBody();

		//convert response body to string
		String responseBody = b.asString();

		//JSON Representation from Response Body
		//JsonPath is an alternative to using XPath for easily getting values from a Object document
		JsonPath jsnPath = res.jsonPath();
		String email = jsnPath.get("data.email[0]");
		System.out.println("Email address is : " + email);
		Assert.assertEquals(email, "michael.lawson@reqres.in", "Email is not matching");


		//get values of JSON array after getting array size
		int s = jsnPath.getInt("data.id.size()");
		for(int i = 0; i < s; i++) {
			String firstname = jsnPath.getString("data["+i+"].first_name");
			String emailAddress = jsnPath.getString("data["+i+"].email");
			System.out.println(firstname);
			System.out.println(emailAddress);
		}

	}

}