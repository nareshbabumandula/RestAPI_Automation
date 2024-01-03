package stepDef;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import org.hamcrest.Matchers;

public class ReqResSteps {

    private Response response;
    private String userId;

    @Given("^I have a new user with name \"([^\"]*)\" and job \"([^\"]*)\"$")
    public void iHaveANewUserWithNameAndJob(String name, String job) {
        String requestBody = "{\"name\": \"" + name + "\", \"job\": \"" + job + "\"}";
        response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .post("https://reqres.in/api/users");
    }

    @When("^I send a POST request to create a user$")
    public void iSendAPOSTRequestToCreateAUser() {
        userId = response.then()
                .statusCode(201)
                .body("name", Matchers.notNullValue())
                .body("job", Matchers.notNullValue())
                .extract().jsonPath().getString("id");
    }

    @Given("I have an existing user with ID {string}")
    public void i_have_an_existing_user_with_id(String string) {
        
    }
    
    @When("^I send a GET request to retrieve the user by ID$")
    public void iSendAGETRequestToRetrieveTheUserByID() {
        response = RestAssured.get("https://reqres.in/api/users/" + userId);
    }

    @When("^I send a PUT request to update the user's job to \"([^\"]*)\"$")
    public void iSendAPUTRequestToUpdateTheUserJob(String newJob) {
        String requestBody = "{\"job\": \"" + newJob + "\"}";
        response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .put("https://reqres.in/api/users/" + userId);
    }

    @When("^I send a PATCH request to update the user's name to \"([^\"]*)\"$")
    public void iSendAPATCHRequestToUpdateTheUserName(String newName) {
        String requestBody = "{\"name\": \"" + newName + "\"}";
        response = RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .patch("https://reqres.in/api/users/" + userId);
    }

    @When("^I send a DELETE request to delete the user$")
    public void iSendADELETERequestToDeleteTheUser() {
        response = RestAssured.delete("https://reqres.in/api/users/" + userId);
    }

    @Then("^the status code should be (\\d+)$")
    public void theStatusCodeShouldBe(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }

    @Then("^the response should contain user ID$")
    public void theResponseShouldContainUserID() {
        assertNotNull(userId);
    }

    @Then("^the user name should be \"([^\"]*)\"$")
    public void theUserNameShouldBe(String expectedName) {
        response.then().body("name", Matchers.equalTo(expectedName));
    }

    @Then("^the user job should be \"([^\"]*)\"$")
    public void theUserJobShouldBe(String expectedJob) {
        response.then().body("job", Matchers.equalTo(expectedJob));
    }

    @Then("^the response should contain user data$")
    public void theResponseShouldContainUserData() {
        response.then().body("data", Matchers.notNullValue());
    }

    @Then("^the user's ID should be \"([^\"]*)\"$")
    public void theUserIDShouldBe(String expectedId) {
        response.then().body("data.id", Matchers.equalTo(Integer.parseInt(expectedId)));
    }
}

