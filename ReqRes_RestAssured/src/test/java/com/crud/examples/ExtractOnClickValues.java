package com.crud.examples;

import io.restassured.path.json.JsonPath;

public class ExtractOnClickValues {

    public static void main(String[] args) {
        String jsonString = "{\"menu\": {\"id\": \"file\",\"value\": \"File\",\"popup\": {\"menuitem\": [{\"value\": \"New\",\"onclick\": \"CreateDoc()\"},{\"value\": \"Open\",\"onclick\": \"OpenDoc()\"},{\"value\": \"Save\",\"onclick\": \"SaveDoc()\"}]}}}";

        JsonPath jsonPath = new JsonPath(jsonString);

        // Extract all onclick values using JsonPath
        Object onclickValues = jsonPath.get("menu.popup.menuitem.findAll { it.containsKey('onclick') }.onclick");

        // Print the extracted onclick values
        System.out.println("onclick values: " + onclickValues);
    }
}
