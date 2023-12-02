package com.crud.examples;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class IterateJSONAarray {

	@Test
	public void jsonIterateArray() {

		//base URI with Rest Assured class
		RestAssured.baseURI = "https://reqres.in/";

		//obtain Response from GET request
		Response res = RestAssured
				.get("api/users?page=2");

		//convert JSON to string
		JsonPath j = new JsonPath(res.asString());

		//get values of JSON array after getting array size
		int s = j.getInt("data[0].size()");
		for(int i = 0; i < s; i++) {
			String email = j.getString("data["+i+"].email");
			String firstname = j.getString("data["+i+"].first_name");
			System.out.println(email);
			System.out.println(firstname);
		}
	}

}
