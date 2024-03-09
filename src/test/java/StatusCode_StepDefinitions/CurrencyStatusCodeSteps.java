package StatusCode_StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CurrencyStatusCodeSteps {
    protected String url;
    protected Response response;

    @Given("I am on the website the URL {string}")
    public void setUpUrl(String url) {
        RestAssured.config = RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation());
        this.url = url;
    }

    @When("Get content")
    public void getResponse() {
        response = RestAssured.get(url);
    }


    @Then("Check that response does not have empty body")
    public void checkThatResponseHasNotEmptyBody() {

        assertNotNull("Response content cannot be empty", response.getBody().asString());
    }

    @Then("Returns status code 200")
    public void returnsStatusCode() {

        assertEquals("Response status code must be 200", 200, response.getStatusCode());
    }
}
