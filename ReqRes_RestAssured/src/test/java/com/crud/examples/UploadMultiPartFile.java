package com.crud.examples;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;
import java.io.File;
public class UploadMultiPartFile {
    @Test
    public void uploadFile() {
        File testUploadFile = new File("C:\\temp\\testfile.png"); //Specify your own location and file
        RestAssured.baseURI = "http://localhost:8080";
        Response response = given()
            .multiPart(testUploadFile)
            .when().
        post("/uploadFile");

        System.out.println(response.getStatusCode());
        System.out.println(response.asString());
        assertTrue(response.asString().contains("successfully uploaded"));
    }
}