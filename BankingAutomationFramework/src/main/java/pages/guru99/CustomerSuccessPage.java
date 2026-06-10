package pages.guru99;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestContext;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CustomerSuccessPage extends BasePage {

    public CustomerSuccessPage(WebDriver driver) {
        super(driver);
    }

    public String getCustomerId() {

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(20));

        WebElement customerElement =
                wait.until(
                        ExpectedConditions
                                .visibilityOfElementLocated(
                                        By.xpath(
                                                "//td[text()='Customer ID']/following-sibling::td")));

        String customerId =
                customerElement.getText();

        TestContext.setCustomerId(customerId);

        return customerId;
    }
}