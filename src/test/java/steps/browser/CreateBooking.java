package steps.browser;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import pageobjects.BasePage;
import pageobjects.CreateHotelBooking;


public class CreateBooking extends BasePage {
    CreateHotelBooking createHotelBooking = new CreateHotelBooking();


    @Given("^I am on the Hotel Booking home page$")
    public void iAmOnTheHotelBookingHomePage(){
        driver = initializeDriver();
        driver.get("http://hotel-test.equalexperts.io/");
        createHotelBooking.infoLog("I am on the Hotel Booking home page");
    }


    @When("^I enter my Firstname as ([^\"]*)$")
    public void iEnterMyFirstnameAs(String firstname) {
        createHotelBooking.setFirstName(firstname);
        createHotelBooking.infoLog("I enter my first name as "+firstname);

    }

    @And("^I enter my Lastname as ([^\"]*)$")
    public void iEnterMyLastnameAs(String lastname) {
        createHotelBooking.setLastName(lastname);
        createHotelBooking.infoLog("I enter my last name as "+lastname);
    }

    @And("^I enter the price as ([^\"]*)$")
    public void iEnterThePriceAs(float totalPrice) {
        createHotelBooking.setTotalPrice(totalPrice);
        createHotelBooking.infoLog("I enter the price as "+totalPrice);

    }

    @And("^I enter the ([^\"]*) paid$")
    public void iEnterThe(String deposit) {
        createHotelBooking.setDepositPaid(deposit);
        createHotelBooking.infoLog("I enter the deposit paid as "+deposit);

    }

    @And("^I enter the Checkin date as ([^\"]*)$")
    public void iEnterTheCheckinDateAs(String checkin) {
        createHotelBooking.setCheckin(checkin);
        createHotelBooking.infoLog("I enter the Checkin date as "+ checkin);

    }

    @And("^I enter the Checkout date as ([^\"]*)$")
    public void iEnterTheCheckoutDateAs(String checkout) {
        createHotelBooking.setCheckOut(checkout);
        createHotelBooking.infoLog("I enter the Checkout date as "+ checkout);

    }
    @And("^I click on the save button$")
    public void iClickOnTheSaveButton() {
        createHotelBooking.setSaveRecord();
        createHotelBooking.infoLog("I click on the Save Button");

    }

    @Then("^The booking is saved successfully for ([^\"]*)$")
    public void theBookingIsSavedSuccessfullyFor(String firstname) {
       Boolean recordExists = createHotelBooking.checkRecordExists(firstname);
        Assert.assertTrue(recordExists);
        if(recordExists){
            createHotelBooking.infoLog("The Booking is saved successfully for "+ firstname);
        }else{
            createHotelBooking.failureLog("The Booking is not saved successfully for "+ firstname);
        }

    }
    @Before
    public void beforeScenario(Scenario scenario){
        softAssert = new SoftAssertions();
        createHotelBooking.generateReport(scenario.getName());

    }
    @After
    public void closeBrowserAfterExecution(){
        createHotelBooking.flushReports();
        softAssert.assertAll();
        driver.quit();

    }

    @And("I enter the price as <price>")
    public void iEnterThePriceAsPrice() {
    }
}
