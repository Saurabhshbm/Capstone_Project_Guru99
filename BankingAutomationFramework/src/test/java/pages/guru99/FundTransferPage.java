package pages.guru99;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WaitUtils;

public class FundTransferPage extends BasePage {

    private static final Logger logger =
            LogManager.getLogger(FundTransferPage.class);

    public FundTransferPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "payersaccount")
    private WebElement payerAccountTxt;

    @FindBy(name = "payeeaccount")
    private WebElement payeeAccountTxt;

    @FindBy(name = "ammount")
    private WebElement amountTxt;

    @FindBy(name = "desc")
    private WebElement descriptionTxt;

    @FindBy(name = "AccSubmit")
    private WebElement submitBtn;

    public void transferFund(
            String payerAccount,
            String payeeAccount,
            String amount,
            String description) {

        logger.info("Performing Fund Transfer");

        payerAccountTxt.sendKeys(payerAccount);
        payeeAccountTxt.sendKeys(payeeAccount);
        amountTxt.sendKeys(amount);
        descriptionTxt.sendKeys(description);

        WaitUtils.waitForClickable(submitBtn);
        submitBtn.click();
    }
}