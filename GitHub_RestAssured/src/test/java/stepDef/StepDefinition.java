package stepDef;

import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import resources.CommonFunctions;
import resources.LinkConstants;
import utility.FrameworkUtility;


public class StepDefinition extends CommonFunctions{

	RequestSpecification reqSpec;
	RequestSpecification reqSpec2;
	FrameworkUtility utility;
	Response response;

	@Given("Github API exists")
	public void github_get_api_exists() {		
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
		response = reqSpec.auth().preemptive().basic(utility.readConfigurationFile("key"),utility.readConfigurationFile("token"))
				.get(LinkConstants.UPDATEDELETEREPO+"/"+idvalue);
		System.out.println("Response code after getting the project : " + response.getStatusCode());
	    JsonPath jsnPath = response.jsonPath();
	    System.out.println(jsnPath.get("name"));
	}

	@When("^Github PUT API is called for the id (.+) and (.+)$")
	public void gitub_put_api_is_called_for_the_id_and(String idvalue, String nameValue) {
		log.info("Calling Github PUT API...");
		System.out.println("Calling Github PUT API..!");
		RequestSpecification request = RestAssured.given();
		JSONObject requestBody = new JSONObject(); 
		requestBody.put("name", nameValue.trim());
		requestBody.put("description", "Test Project updated by RestAssured");
		requestBody.put("homepage", "https://api.github.com");
		requestBody.put("private", false);
		requestBody.put("has_issues", true);
		requestBody.put("has_projects", true);

		request.body(requestBody.toJSONString());

		Response response = request.auth().preemptive().basic(utility.readConfigurationFile("key"),utility.readConfigurationFile("token"))
				.put("https://api.github.com/repos/nareshbabumandula/" +idvalue);
		System.out.println("Response code is : " + response.getStatusCode());

	}
	

	@When("^Github DELETE API is called for the id (.+)$")
	public void github_delete_api_is_called_for_the_id(String idvalue) {
		log.info("Calling Github DELETE API...");
		System.out.println("Calling Github DELETE API..!");
		response = reqSpec.auth().preemptive().basic(utility.readConfigurationFile("key"),utility.readConfigurationFile("token"))
				.delete(LinkConstants.UPDATEDELETEREPO+"/"+idvalue);
		System.out.println("Response code after deleting the project : " + response.getStatusCode());
		System.out.println("Deleted the project : " + idvalue);
	}

	@When("^Github POST API is called with the name (.+)$")
	public void github_post_api_is_called_with_the_name(String project) {

		RestAssured.baseURI = FrameworkUtility.readConfigurationFile("baseURI"); 
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
		response = reqSpec.auth().preemptive().basic(utility.readConfigurationFile("key"),utility.readConfigurationFile("token"))
				.header("Content-Type", "application/json")
				.body(requestParams.toJSONString()).when()
				.post(LinkConstants.REPO);
		System.out.println("Response code is : " + response.getStatusCode());
	}

	@Then("Verify the status code is {string}")
	public void verify_the_status_code_is(String string) {
		log.info("Verifying the status code...");
		System.out.println("Response code is : " + response.statusCode());
		response.then().assertThat().statusCode(Integer.parseInt(string));
	}

	@When("^Github PATCH API is called for the id (.+) and (.+)$")
	public void gitub_patch_api_is_called_for_the_id_and(String idvalue, String description) {
		log.info("Calling Github PATCH API...");
		System.out.println("Calling Github PATCH API..!");
		// Base URL for GitHub API
        RestAssured.baseURI = "https://api.github.com";

        // Authentication if required
        RestAssured.authentication = RestAssured.preemptive().basic(utility.readConfigurationFile("key"),utility.readConfigurationFile("token"));
        RequestSpecification request = RestAssured.given();
        
        // JSON payload for the PATCH request
    	JSONObject requestParams = new JSONObject(); 
		requestParams.put("name", idvalue);
		requestParams.put("description", description);
		requestParams.put("homepage", "https://api.github.com");
		requestParams.put("private", false);
		requestParams.put("has_issues", true);
		requestParams.put("has_projects", true);

        // PATCH request to update repository description
        RestAssured.given()
            .contentType(ContentType.JSON)
            .body(requestParams.toJSONString())
            .when()
            .patch("/repos/nareshbabumandula/TestRepository127_Updated") // Replace 'username' and 'repositoryName' with actual values
            .then()
            .statusCode(200); // Check for the expected status code

        Response response = request.auth().preemptive().basic(utility.readConfigurationFile("key"),utility.readConfigurationFile("token"))
				.put("/repos/nareshbabumandula/" +idvalue);
		System.out.println("Response code is : " + response.getStatusCode());
    }
	
}

