package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = {"classpath:features/"},
        glue = {"steps.browser", "hooks"},
        tags = {"@DeleteBooking", "~@ignore"},
        plugin = {

                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        },
        strict = true,
        monochrome = true)
public class DeleteBooking extends AbstractTestNGCucumberTests {
}
