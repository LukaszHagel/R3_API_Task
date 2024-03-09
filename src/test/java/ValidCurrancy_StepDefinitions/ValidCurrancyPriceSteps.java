package ValidCurrancy_StepDefinitions;

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

public class ValidCurrancyPriceSteps {
    protected String url;
    protected Response response;

    private String secondCurrency = "AED";

    @Given("I am on the website the URL {string}")
    public void setUpUrl(String url) {
        RestAssured.config = RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation());
        this.url = url;
    }

    @When("Get content")
    public void getResponse() {
        response = RestAssured.get(url);
    }


    @Then("Check that currency price is valid")
    public void checkThatCurrencyPriceIsValid() {
        // Check if the response is not empty and the status code is 200
        assertNotNull("Response content cannot be empty", response.getBody().asString());
        assertEquals("Response status code must be 200", 200, response.getStatusCode());

// Parsing response body to JsonObject
        JsonObject jsonObject = JsonParser.parseString(response.getBody().asString()).getAsJsonObject();
        double secondCurrentValue = jsonObject.getAsJsonObject("rates").get(secondCurrency).getAsDouble();
        System.out.println("Currency " + secondCurrency + ": " + secondCurrentValue);
        System.out.println("Fetched content: " + jsonObject);
        Assert.assertTrue("Currency price is not valid", secondCurrentValue == 3.6725);
    }
}
