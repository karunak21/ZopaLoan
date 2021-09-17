package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

public class ZopaPageObjects extends BasePage{
        public static final String PERSONALISEDBUTTON = "//div[2]//button[contains(@data-automation,'ZA.button-personal-rate')]";

    public static void setPersonalisedButton(){

        softAssert.assertThat(driver.findElement(By.xpath(PERSONALISEDBUTTON)));
        driver.findElement(By.xpath(PERSONALISEDBUTTON)).click();

    }


}
