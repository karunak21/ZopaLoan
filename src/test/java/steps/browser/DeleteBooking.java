package steps.browser;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.testng.Assert;
import pageobjects.BasePage;
import pageobjects.CreateHotelBooking;
import pageobjects.DeleteHotelBooking;

import static pageobjects.BasePage.*;

public class DeleteBooking {
    CreateHotelBooking createHotelBooking = new CreateHotelBooking();
    DeleteHotelBooking deleteHotelBooking = new DeleteHotelBooking();


    @When("^I see a booking for ([^\"]*)$")
    public void iSeeABookingForFirstname(String firstname) {
        Boolean recordExists  = createHotelBooking.checkRecordExists(firstname);
        Assert.assertTrue(recordExists);
        if(recordExists){
            deleteHotelBooking.infoLog("The Booking exists for "+ firstname);
        }else{
            createHotelBooking.infoLog("The Booking doesn't exist for "+ firstname);
        }
    }

    @And("^I click on delete button for ([^\"]*)$")
    public void iClickOnDeleteButtonFor(String firstname) {
        deleteHotelBooking.deleteBooking(firstname);
        deleteHotelBooking.infoLog("I click on delete button for "+ firstname);
    }

    @Then("^The booking is deleted for ([^\"]*)$")
    public void theBookingIsDeleted(String firstname) {
        Boolean recordExists  = createHotelBooking.checkRecordExists(firstname);
        //Assert.assertTrue(recordExists);
        if(recordExists){
            deleteHotelBooking.failureLog("The Booking is not deleted for "+ firstname);
        }else{
            createHotelBooking.infoLog("The Booking is deleted successfully for "+ firstname);
        }
    }
    @Before
    public void beforeScenario(Scenario scenario){
        softAssert = new SoftAssertions();
        BasePage.generateReport(scenario.getName());

    }
    @After
    public void closeBrowserAfterExecution(){
        BasePage.flushReports();
        softAssert.assertAll();
        driver.quit();

    }

}
