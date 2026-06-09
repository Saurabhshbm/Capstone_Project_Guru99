package pages.guru99;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WithdrawalSuccessPage extends BasePage {

    public WithdrawalSuccessPage(WebDriver driver) {
        super(driver);
    }

    public boolean isWithdrawalSuccessful() {

        return driver.findElement(
                By.xpath("//p[contains(text(),'Transaction details of Withdrawal')]"))
                .isDisplayed();
    }

    public String getTransactionId() {

        try {

            return driver.findElement(
                    By.xpath("//td[text()='Transaction ID']/following-sibling::td"))
                    .getText();

        } catch (Exception e) {

            return "NOT AVAILABLE";
        }
    }

    public void printWithdrawalDetails() {

        System.out.println(
                "Withdrawal Successful");

        System.out.println(
                "Transaction ID : "
                        + getTransactionId());
    }
}