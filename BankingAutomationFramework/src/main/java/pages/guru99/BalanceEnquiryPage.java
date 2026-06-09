package pages.guru99;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WaitUtils;

public class BalanceEnquiryPage extends BasePage {

    private static final Logger logger =
            LogManager.getLogger(BalanceEnquiryPage.class);

    public BalanceEnquiryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "accountno")
    private WebElement accountNumberTxt;

    @FindBy(name = "AccSubmit")
    private WebElement submitBtn;

    public void searchAccount(String accountNumber) {

        logger.info("Performing Balance Enquiry");

        accountNumberTxt.clear();
        accountNumberTxt.sendKeys(accountNumber);

        WaitUtils.waitForClickable(submitBtn);

        submitBtn.click();
    }
}