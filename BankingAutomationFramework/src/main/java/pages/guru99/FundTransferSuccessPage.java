package pages.guru99;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FundTransferSuccessPage extends BasePage {

    public FundTransferSuccessPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFundTransferSuccessful() {

        return driver.findElement(
                By.xpath("//*[contains(text(),'Fund Transfer Details')]"))
                .isDisplayed();
    }

    public void printFundTransferDetails() {

        System.out.println(
                "Fund Transfer Successful");
    }
}