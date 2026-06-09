package pages.guru99;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestContext;

public class CustomerSuccessPage extends BasePage {

    public CustomerSuccessPage(WebDriver driver) {
        super(driver);
    }

    public String getCustomerId() {

        String customerId =
                driver.findElement(
                        By.xpath(
                                "//td[text()='Customer ID']/following-sibling::td"))
                        .getText();

        TestContext.setCustomerId(customerId);

        return customerId;
    }
}