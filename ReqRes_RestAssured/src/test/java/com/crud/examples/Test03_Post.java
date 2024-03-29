package com.crud.examples;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Test03_Post {

    @Test
    public void test2() {

        JSONObject request = new JSONObject();
        request.put("name", "chaya");
        request.put("job", "BA");

        System.out.println(request);
        System.out.println(request.toString());

        given().
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().statusCode(201);
        
        Response response = given()
                .contentType(ContentType.JSON)
                .body(request)
                .post("https://reqres.in/api/users"); 

        
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 201, "Status code is not 201");

        // Validate the response body using JSONPath or other methods
        String responseBody = response.getBody().asString();
        // Add your validation logic here based on the response body

        // For example, to validate a specific field in the JSON response:
        String fieldValue = response.jsonPath().get("name");
        assertEquals(fieldValue, "chaya", "Field value is incorrect");

    }

}

