package pages.guru99;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.WaitUtils;

public class AccountPage extends BasePage {

    private static final Logger logger =
            LogManager.getLogger(AccountPage.class);

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "cusid")
    private WebElement customerIdTxt;

    @FindBy(name = "selaccount")
    private WebElement accountTypeDropdown;

    @FindBy(name = "inideposit")
    private WebElement initialDepositTxt;

    @FindBy(name = "button2")
    private WebElement submitBtn;

    public void createAccount(
            String customerId,
            String accountType,
            String initialDeposit) {

        logger.info("Creating New Account");

        customerIdTxt.clear();
        customerIdTxt.sendKeys(customerId);

        Select select =
                new Select(accountTypeDropdown);

        select.selectByVisibleText(accountType);

        initialDepositTxt.clear();
        initialDepositTxt.sendKeys(initialDeposit);

        System.out.println(
                "Customer ID = "
                        + customerIdTxt.getAttribute("value"));

        System.out.println(
                "Initial Deposit = "
                        + initialDepositTxt.getAttribute("value"));

        WaitUtils.waitForClickable(submitBtn);

        submitBtn.click();
    }
}