package pages.guru99;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WaitUtils;

public class DepositPage extends BasePage {

    private static final Logger logger =
            LogManager.getLogger(DepositPage.class);

    public DepositPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "accountno")
    private WebElement accountNumberTxt;

    @FindBy(name = "ammount")
    private WebElement amountTxt;

    @FindBy(name = "desc")
    private WebElement descriptionTxt;

    @FindBy(name = "AccSubmit")
    private WebElement submitBtn;

    public void depositAmount(
            String accountId,
            String amount,
            String description) {

        logger.info("Performing Deposit");

        accountNumberTxt.sendKeys(accountId);

        amountTxt.sendKeys(amount);

        descriptionTxt.sendKeys(description);

        WaitUtils.waitForClickable(submitBtn);

        submitBtn.click();
    }
}