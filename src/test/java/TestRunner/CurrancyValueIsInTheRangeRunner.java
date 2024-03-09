package TestRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/ApiTask/CurrencyValueIsInTheRange.feature",
        plugin = "pretty",
        glue = "CurrencyValiueIsInTheRange_StepsDefinitions",
        monochrome = true)
public class CurrancyValueIsInTheRangeRunner {}