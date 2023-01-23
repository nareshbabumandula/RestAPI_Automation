package stepDef;

import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.PropertySource.Comparator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.CommonFunctions;
import resources.LinkConstants;


public class StepDefinition extends CommonFunctions{

	RequestSpecification reqSpec;
	RequestSpecification reqSpec2;
	Response response;

	@Given("Github API exists")
	public void trello_get_api_exists() {		
		log.info("Setting GET/PUT/DELETE API Base URI...");
		reqSpec = given().spec(requestSpecification());		
	}

	@Given("Github POST API exists")
	public void github_post_api_exists() {		
		log.info("Setting POST API Base URI...");
		reqSpec = given().spec(postRequestSpecification());		
	}

	@When("^Github GET API is called for the id (.+)$")
	public void github_get_api_is_called_for_the_id(String idvalue){
		log.info("Calling Github GET API...");
		System.out.println("Calling Github GET API..!");
		response = reqSpec.auth().preemptive().basic("nareshbabumandula","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")
				.get(LinkConstants.UPDATEDELETEREPO+"/"+idvalue);
		System.out.println("Response code after getting the project : " + response.getStatusCode());
	}

	@When("^Github PUT API is called for the id (.+) and (.+)$")
	public void gitub_put_api_is_called_for_the_id_and(String idvalue, String nameValue) {
		log.info("Calling Github PUT API...");
		System.out.println("Calling Github PUT API..!");
		response = reqSpec.auth().preemptive().basic("nareshbabumandula","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")
				.put(LinkConstants.UPDATEDELETEREPO+"/"+idvalue);
		System.out.println("Response code after updating the project : " + response.getStatusCode());
		System.out.println("Updated the project : " + idvalue + " with " +nameValue);
	}

	@When("^Github DELETE API is called for the id (.+)$")
	public void github_delete_api_is_called_for_the_id(String idvalue) {
		log.info("Calling Github DELETE API...");
		System.out.println("Calling Github DELETE API..!");
		response = reqSpec.auth().preemptive().basic("nareshbabumandula","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")
				.delete(LinkConstants.UPDATEDELETEREPO+"/"+idvalue);
		System.out.println("Response code after deleting the project : " + response.getStatusCode());
		System.out.println("Deleted the project : " + idvalue);
	}

	@When("^Github POST API is called with the name (.+)$")
	public void github_post_api_is_called_with_the_name(String project) {

		RestAssured.baseURI = "https://api.github.com"; 
		// JSONObject is a class that represents a Simple JSON. 
		// We can add Key - Value pairs using the put method 
		JSONObject requestParams = new JSONObject(); 
		requestParams.put("name", project);
		requestParams.put("description", "Test Project created by RestAssured");
		requestParams.put("homepage", "https://api.github.com");
		requestParams.put("private", false);
		requestParams.put("has_issues", true);
		requestParams.put("has_projects", true);

		log.info("Calling Github POST API..."); 
		response = reqSpec.auth().preemptive().basic("nareshbabumandula","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")
				.header("Content-Type", "application/json")
				.body(requestParams.toJSONString()).when()
				.post(LinkConstants.REPO);
	}

	@Then("Verify the status code is {int}")
	public void verify_the_status_code_is(Integer int1) {
		log.info("Verifying the status code...");
		response.then().assertThat().statusCode(int1);
	}


}

