package steps.browser;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.testng.Assert;
import pageobjects.BasePage;
import pageobjects.ZopaPageObjects;


public class ZopaFirstPage extends BasePage {
    ZopaPageObjects zopaPageObjects = new ZopaPageObjects();

    @Given("^I am on the Zopa loans home page$")
    public void iAmOnTheZopaHomePage() {
        driver = initializeDriver();
        driver.get("https://www.zopa.com/loans");
        zopaPageObjects.infoLog("I am on the Zopa loans home page");
    }


    @When("^I click on the Personalised Loan button$")
    public void iClickPersonalisedButton() {
        zopaPageObjects.setPersonalisedButton();
    }

    @Then("the Loan page is displayed$")

 public void theLoanPageDisplayed() {
       String loanPageURL = driver.getCurrentUrl();
        if (loanPageURL.contains("https://rates.zopa.com/")){
            softAssert.assertThat(loanPageURL);
        }
   }

    @Before
    public void beforeScenario(Scenario scenario) {
        softAssert = new SoftAssertions();
        zopaPageObjects.generateReport(scenario.getName());

    }

    @After
    public void closeBrowserAfterExecution() {
        zopaPageObjects.flushReports();
        softAssert.assertAll();
        driver.quit();

    }
}
