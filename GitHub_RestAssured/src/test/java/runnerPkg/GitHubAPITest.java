package runnerPkg;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.junit.Test;

public class GitHubAPITest {

    @Test
    public void createRepositoryOnGitHub() {
        // Base URL for GitHub API
        RestAssured.baseURI = "https://api.github.com";

        // Replace these variables with your GitHub username, repository name, and personal access token
        String username = "naresh223@gmail.com";
        String repoName = "TestRepo123456";
        String accessToken = "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";

        // JSON payload for creating a repository
        //String requestBody = "{\"name\": \"" + repoName + "\", \"description\": \"Created via API\", \"private\": false}";
        String requestBody = "{\r\n"
        		+ "  \"name\": \"TestRepo123456\",\r\n"
        		+ "  \"description\": \"This is your first repo!\",\r\n"
        		+ "  \"homepage\": \"https://github.com\",\r\n"
        		+ "  \"private\": false,\r\n"
        		+ "  \"is_template\": true\r\n"
        		+ "}";

        // Send POST request to create a repository
        Response response = given()
                .header("Authorization", "token " + accessToken)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("/user/repos");

        // Validate the response
        response.then().statusCode(201); // Ensure the repository was created (status code 201)

        System.out.println("Repository '" + repoName + "' created successfully!");
    }
}
