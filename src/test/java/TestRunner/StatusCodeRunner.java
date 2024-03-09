package TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/ApiTask/StatusCodeAndEmptyBody.feature",
        plugin = "pretty",
        glue = "StatusCode_StepDefinitions",
        monochrome = true)
public class StatusCodeRunner {}