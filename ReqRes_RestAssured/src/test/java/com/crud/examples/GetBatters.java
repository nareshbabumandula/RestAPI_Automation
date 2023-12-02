package com.crud.examples;

import java.util.List;

import io.restassured.path.json.JsonPath;

public class GetBatters {

	public static void main(String[] args) {
		String jsonResponse = "{\r\n"
				+ "  \"product\": \"0001\",\r\n"
				+ "  \"name\": \"Cake\",\r\n"
				+ "  \"batters\": {\r\n"
				+ "    \"batter\": [\r\n"
				+ "      {\r\n"
				+ "        \"id\": \"1001\",\r\n"
				+ "        \"type\": \"Regular\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"id\": \"1002\",\r\n"
				+ "        \"type\": \"Chocolate\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"id\": \"1003\",\r\n"
				+ "        \"type\": \"Blueberry\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"id\": \"1003\",\r\n"
				+ "        \"type\": \"Blackberry\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"id\": \"1004\",\r\n"
				+ "        \"type\": \"Devil's Food\"\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}";

		// Parse the JSON response using Rest Assured's JsonPath
		JsonPath jsonPath = new JsonPath(jsonResponse);

		// Extract the 'type' attribute where 'id' is '1003'
		String type = jsonPath.getString("batters.batter.find {it.id == '1003' }.type");
		String id = jsonPath.getString("batters.batter.find {it.type == 'Regular' }.id");

		// Display the extracted 'type' attribute
		System.out.println("Type attribute where id=1003: " + type);
		// Display the extracted 'id' attribute
		System.out.println("ID attribute where type=Regular: " + id);

		// Extract all 'type' attributes where 'id' is '1003'
		List<String> types = jsonPath.getList("batters.batter.findAll { it.id == '1003' }.type");

		// Display the extracted 'type' attributes
		System.out.println("Type attributes where id=1003:");
		for (String itype : types) {
			System.out.println(itype);
		}

		//Response response = RestAssured.get("https://api.example.com/data");

		//Different ways to extract json response in restassured

		/*
		 * 1. Using JSONPath: Rest Assured provides support for JSONPath, which is a
		 * query language for JSON, allowing you to extract specific parts of a JSON
		 * response.
		 */

		// Extracting a single value using JSONPath
		String strtype = jsonPath.getString("batters.batter[0].type");
		System.out.println(strtype);


		// Extracting a list of values using JSONPath
		List<String> ids = jsonPath.getList("batters.batter.id");
		for (String value : ids) {
			System.out.println(value);
			if (value.equals("1003")) {
				break;
			}
		}

		/*
		 * 2. Using GSON or Jackson Libraries: Rest Assured allows you to obtain the
		 * response body as a String, which you can then convert to a Java object using
		 * external libraries like GSON or Jackson.
		 * 
		 * Example using GSON:
		 */
		//Response response = RestAssured.get("https://api.example.com/data");

		// Get response body as String
		//String responseBody = response.getBody().asString();

		// Parse response String to JsonObject using GSON
		//JsonObject jsonObject = new JsonParser().parse(responseBody).getAsJsonObject();

		// Extract values from JsonObject
		// String value = jsonObject.get("keyName").getAsString();


		/*
		 * 3. Using Path and XML Path: Rest Assured also provides support for extracting
		 * values using XMLPath and Path when dealing with XML and JSON responses.
		 * 
		 * Example using Path:
		 */
		
		//Response response = RestAssured.get("https://api.example.com/data");

		// Extracting a single value using Path
		//String value = response.path("keyName");
		
	}


}
