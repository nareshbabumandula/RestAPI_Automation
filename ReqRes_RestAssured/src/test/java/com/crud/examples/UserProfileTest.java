package com.crud.examples;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class UserProfileTest {
	private static final String URL = "https://reqres.in";
	private int UserId;

	@Test(priority=1)
	public void CreateNewUser () {

		JSONObject request = new JSONObject();
		request.put("name", "kiran");
		request.put("job", "QA");

		Response response = (Response) given().contentType(ContentType.JSON)
				.body (request)
				.when ()
				.post (URL + "/api/users")
				.then ()
				.assertThat ()
				.statusCode (201);
		UserId =response.jsonPath().getInt("userid");

	}


	@Test(priority=2)    
	public void getUserDetails ()  {
		given ().when ()
		.get (URL +"/"+UserId)
		.then ()
		.statusCode (200)
		.and ()
		.assertThat ()
		.body ("data.id", equalTo(UserId));
	}
}