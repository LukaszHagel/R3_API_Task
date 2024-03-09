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
        RestAssured.config = RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation());
        this.url = url;
    }

    @When("Get response")
    public void getResponse() {
        response = RestAssured.get(url);
    }


    @Then("Check that API returns 162 pairs")
    public void checkPairs() {
        JsonObject jsonObject = JsonParser.parseString(response.getBody().asString()).getAsJsonObject();
        assertNotNull("Response content cannot be empty", response.getBody().asString());
        assertEquals("Response status code must be 200", 200, response.getStatusCode());

        JsonObject ratesObject = jsonObject.getAsJsonObject("rates");
        int numberOfPairs = ratesObject.entrySet().size();
        System.out.println("Number of " + numberOfPairs + " pairs are returned by the API");
        assertEquals("Number of pairs returned by API is not equal 162", 162, numberOfPairs);
    }
}
