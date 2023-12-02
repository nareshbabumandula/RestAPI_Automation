package com.crud.examples;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class JSONIterator {
   @Test
   public void jsonIterateArr() {

      //base URI with Rest Assured class
      RestAssured.baseURI = "https://reqres.in";

      //obtain Response from GET request
      Response res = given()
         .when()
         .get("/api/users?page=2");

      //convert JSON to string
      JsonPath j = new JsonPath(res.asString());

      //get values of JSON array after getting array size
      int s = j.getInt("data.id.size()");
      for(int i = 0; i < s; i++) {
         String firstname = j.getString("data["+i+"].first_name");
         String email = j.getString("data["+i+"].email");
         System.out.println(firstname);
         System.out.println(email);
      }
   }
}