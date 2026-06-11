package pages.guru99;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.TestContext;

public class AccountSuccessPage extends BasePage {

    public AccountSuccessPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountId() {

        String accountId =
                driver.findElement(
                        By.xpath(
                                "//td[text()='Account ID']/following-sibling::td"))
                        .getText();

        TestContext.setAccountId(accountId);

        return accountId;
    }
}