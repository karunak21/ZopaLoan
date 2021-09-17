package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DeleteHotelBooking extends BasePage {

    public static void deleteBooking(String firstname) {
        try {
            Thread.sleep(2000);
            wait = explicitWait();
            //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[7]/input"))));


            List<WebElement> rows = driver.findElements(By.xpath("//div[@id='bookings']/div[@class='row']"));
            System.out.println("Rows = "+rows.size());
            for (int i = 0; i < rows.size(); i++) {
                WebElement link = rows.get(i);

                if(link.getText().contains(firstname)) {
                    int j = i + 1;
                    assertThat(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[" + j + "]/div[7]/input")));
                    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[" + j + "]/div[7]/input")).click();
                    Thread.sleep(2000);

                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
