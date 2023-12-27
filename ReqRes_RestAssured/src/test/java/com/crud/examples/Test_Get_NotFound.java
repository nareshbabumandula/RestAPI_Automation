package com.crud.examples;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Test_Get_NotFound {

    @Test
    public void test1() {
    	Response response = RestAssured.get("https://reqres.in/api/users/23");
    	System.out.println(response.getStatusCode());
    	int StatusCode = response.getStatusCode();
    	Assert.assertEquals(StatusCode, 200, "Expected status code is not matching with the actual code");
    }
}
