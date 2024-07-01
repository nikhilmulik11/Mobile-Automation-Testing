package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


    @RunWith(Cucumber.class)
    @CucumberOptions(
            monochrome = true,
            features = {"src/main/resources/features"},
            dryRun = false,
            glue = {"stepDefinations" },tags = "@AddToCart",
            plugin = { "pretty", "html:target/reports/html-report.html", "json:target/reports/json-report.json" })
    public class mobilerunner {


    }