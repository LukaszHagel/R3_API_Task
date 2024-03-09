package CurrencyPairsAreReturned_StepDefinitions;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CurrencyPairsAreReturnedSteps {
    protected String url;
    protected Response response;

    @Given("I am on the website the URL {string}")
    public void setUpUrl(String url) {
        // Configuring RestAssured to relax HTTPS validation
        RestAssured.config = RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation());
        this.url = url;
    }

    @When("Get response")
    public void getResponse() {
        // Sending GET request to the specified URL
        response = RestAssured.get(url);
    }

    @Then("Check that API returns 162 pairs")
    public void checkPairs() {
        // Parsing response body to JSON object
        JsonObject jsonObject = JsonParser.parseString(response.getBody().asString()).getAsJsonObject();

        // Asserting that response content is not empty
        assertNotNull("Response content cannot be empty", response.getBody().asString());

        // Asserting that response status code is 200
        assertEquals("Response status code must be 200", 200, response.getStatusCode());

        // Retrieving rates object from JSON response
        JsonObject ratesObject = jsonObject.getAsJsonObject("rates");

        // Calculating the number of pairs returned by the API
        int numberOfPairs = ratesObject.entrySet().size();
        System.out.println("Number of " + numberOfPairs + " pairs are returned by the API");

        // Asserting that the number of pairs returned by API is equal to 162
        assertEquals("Number of pairs returned by API is not equal 162", 162, numberOfPairs);
    }
}
