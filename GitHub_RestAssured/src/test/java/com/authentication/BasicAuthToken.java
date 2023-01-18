package com.authentication;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BasicAuthToken {
  
  @Test
  void getUserDetails() {
	  RestAssured.baseURI = "https://api.github.com/users/nareshbabumandula/repos";
	  RequestSpecification request = RestAssured.given();
	  Response response = request.request(Method.GET, "");
	  System.out.println("Status received => " + response.getStatusLine());
	  System.out.println(response.getStatusCode());
	  System.out.println(response.getBody().asString());
	  
	//JSON Representation from Response Body
      JsonPath j = response.jsonPath();
      String reponame = j.get("full_name");
      System.out.println(reponame);
   // verify the value of key
   

      
  }
}
