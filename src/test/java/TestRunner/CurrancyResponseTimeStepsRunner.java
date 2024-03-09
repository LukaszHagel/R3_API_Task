package TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/ApiTask/CurrencyResponseTime.feature",
        plugin = "pretty",
        glue = "CurrencyResponseTimeSteps_StepsDefinitions",
        monochrome = true)
public class CurrancyResponseTimeStepsRunner {}