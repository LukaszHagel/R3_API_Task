package CurrencyValiueIsInTheRange_StepsDefinitions;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CurrencyValueIsInTheRangeSteps {
    protected String url;
    protected Response response;

    private String secondCurrency = "AED";

    @Given("I am on the website the URL {string}")
    public void setUpUrl(String url) {
        // Configuring RestAssured to relax HTTPS validation
        RestAssured.config = RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation());
        this.url = url;
    }

    @When("Get content from URl")
    public void getResponse() {
        // Sending GET request to the specified URL
        response = RestAssured.get(url);
    }

    @Then("Check that the AED is in the range 3.6-3.7")
    public void range() {

        // Asserting that response content is not empty
        assertNotNull("Response content cannot be empty", response.getBody().asString());

        // Asserting that response status code is 200
        assertEquals("Response status code must be 200", 200, response.getStatusCode());

        // Parsing response body to JsonObject
        JsonObject jsonObject = JsonParser.parseString(response.getBody().asString()).getAsJsonObject();

        // Displaying fetched content
        double secondCurrentValue = jsonObject.getAsJsonObject("rates").get(secondCurrency).getAsDouble();
        System.out.println("Currency " + secondCurrency + ": " + secondCurrentValue);

        // Asserting that the currency value is within the range of 3.6 to 3.7
        Assert.assertTrue("Currency is out of the range", secondCurrentValue >= 3.6 & secondCurrentValue <= 3.7);

    }
}
