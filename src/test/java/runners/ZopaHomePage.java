package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //strict = true,
        features = {"classpath:features/"},
        glue = {"steps.browser", "hooks"},
        tags = "@CreateZopaLoan or ~gitignore",
        plugin = {
                "pretty",
                "html:target/report/cucumber.html",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
                 },
        //strict = true,
        monochrome = true)
public class ZopaHomePage extends AbstractTestNGCucumberTests {

}
//import io.cucumber.junit.Cucumber;
//        import io.cucumber.junit.CucumberOptions;
//        import org.junit.runner.RunWith;
