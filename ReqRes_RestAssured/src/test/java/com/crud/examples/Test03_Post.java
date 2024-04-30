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

        Response response = given().  // pre-condition
                body(request.toJSONString()).
                when(). // action
                post("https://reqres.in/api/users").
                then().extract().response(); // outcome
             
        
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

