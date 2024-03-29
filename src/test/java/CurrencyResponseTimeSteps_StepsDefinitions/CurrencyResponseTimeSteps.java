package CurrencyResponseTimeSteps_StepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

import java.time.Instant;

import static org.junit.Assert.*;

public class CurrencyResponseTimeSteps {

    private Instant requestTime;
    private Instant responseTime;
    protected String url;
    protected Response response;

    @Given("I am on the website the URL {string}")
    public void setUpUrl(String url) {
        // Configuring RestAssured to relax HTTPS validation
        RestAssured.config = RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation());
        this.url = url;
    }

    @When("Get content")
    public void getResponse() {
        // Sending GET request to the specified URL
        response = RestAssured.get(url);
    }


    @When("Get the request and response time")
    public void GetTheRequestAndResponseTime() {
        // Record the time when the request is sent
        requestTime = Instant.now();

        // Sending GET request to the specified URL and record response time
        response = RestAssured.get(url);

        // Record the time when the response is received
        responseTime = Instant.now();
    }

    @Then("Check that API response time is not less than 3 seconds")
    public void checkApiResponseTime() {
        // Retrieving response from the URL
        response = RestAssured.get(url);

        // Asserting that response content is not empty
        assertNotNull("Response content cannot be empty", response.getBody().asString());

        // Asserting that response status code is 200
        assertEquals("Response status code must be 200", 200, response.getStatusCode());

        // Calculate the response time in seconds
        long responseDuration = responseTime.getEpochSecond() - requestTime.getEpochSecond();
        System.out.println("Response time: " + responseDuration + " seconds");

        // Check if the response time is not less than 3 seconds
        assertTrue("Response time should has at least 3 seconds", responseDuration >= 3);
    }
}
