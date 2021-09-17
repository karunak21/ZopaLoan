package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features/"},
        glue = {"steps.browser", "hooks"},
        tags = "@CreateZopaLoan",
        plugin = {

                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        },
        //strict = true,
        monochrome = true)
public class ZopaHomePage extends AbstractTestNGCucumberTests {

}
