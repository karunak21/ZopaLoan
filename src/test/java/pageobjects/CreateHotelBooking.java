package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;


public class CreateHotelBooking extends BasePage {
public static final String FIRSTNAME = "firstname";
public static final String LASTNAME = "lastname";
public static final String TOTALPRICE = "totalprice";
public static final String DEPOSITPAID = "depositpaid";
public static final String CHECKIN = "checkin";
public static final String CHECKOUT = "checkout";
//public static final String SAVE = "//input[value()=' Save ']";
public static final String SAVE = "/html/body/div[1]/div[3]/div/div[7]/input";


    public static void setFirstName(String firstName){
        softAssert.assertThat(driver.findElement(By.id(FIRSTNAME)));
        driver.findElement(By.id(FIRSTNAME)).sendKeys(firstName);

    }

    public static void setLastName(String lastName){
        softAssert.assertThat(driver.findElement(By.id(LASTNAME)));
        driver.findElement(By.id(LASTNAME)).sendKeys(lastName);

    }

    public static void setTotalPrice(float totalPrice){
        String totalPrice_Val = String.valueOf(totalPrice);
        softAssert.assertThat(driver.findElement(By.id(TOTALPRICE)));
        driver.findElement(By.id(TOTALPRICE)).sendKeys(totalPrice_Val);
    }

    public static void setDepositPaid(String depositPaid){
        softAssert.assertThat(driver.findElement(By.id(DEPOSITPAID)));
        WebElement dropDown = driver.findElement(By.id(DEPOSITPAID));
        Select value_select = new Select(dropDown);
        value_select.selectByVisibleText(depositPaid);

    }
    public static void setCheckin(String checkin){
        softAssert.assertThat(driver.findElement(By.id(CHECKIN)));
        driver.findElement(By.id(CHECKIN)).sendKeys(checkin);

    }



    public static void setCheckOut(String checkout){
        softAssert.assertThat(driver.findElement(By.id(CHECKOUT)));
        driver.findElement(By.id(CHECKOUT)).sendKeys(checkout);

    }
    public static void setSaveRecord(){
        softAssert.assertThat(driver.findElement(By.xpath(SAVE)));
        driver.findElement(By.xpath(SAVE)).click();
    }
    public static boolean checkRecordExists(String firstname) {
        List<WebElement> rows=null;
        try {
            Thread.sleep(4500);

         //   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[7]/input"))));


            rows = driver.findElements(By.xpath("//div[@id='bookings']/div[@class='row']"));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
            int count = 0;
            for (int i = 0; i < rows.size(); i++) {
                WebElement link = rows.get(i);
                if (link.getText().contains(firstname)) {
                    count++;
                } else {
                    continue;
                }
            }
            if (count >= 1) {
                return true;
            } else {
                return false;
            }

    }
}
