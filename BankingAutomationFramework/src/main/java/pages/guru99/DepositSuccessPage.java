package pages.guru99;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DepositSuccessPage extends BasePage {

    public DepositSuccessPage(WebDriver driver) {
        super(driver);
    }

    public boolean isDepositSuccessful() {

        return driver.findElement(
                By.xpath("//*[contains(text(),'Transaction details of Deposit')]"))
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

    public void printDepositDetails() {

        System.out.println(
                "Deposit Successful");

        System.out.println(
                "Transaction ID : "
                        + getTransactionId());
    }
}