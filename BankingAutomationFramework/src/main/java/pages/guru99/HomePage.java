package pages.guru99;

import base.BasePage;
import utilities.WaitUtils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final Logger logger =
            LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath =
            "//td[contains(text(),'Manger Id') or contains(text(),'Manager Id')]")
    private WebElement managerIdLabel;

    @FindBy(linkText = "New Customer")
    private WebElement newCustomerMenu;

    @FindBy(linkText = "New Account")
    private WebElement newAccountMenu;

    @FindBy(linkText = "Deposit")
    private WebElement depositMenu;

    @FindBy(linkText = "Withdrawal")
    private WebElement withdrawalMenu;

    @FindBy(linkText = "Fund Transfer")
    private WebElement fundTransferMenu;

    @FindBy(linkText = "Change Password")
    private WebElement changePasswordMenu;

    @FindBy(linkText = "Balance Enquiry")
    private WebElement balanceEnquiryMenu;

    @FindBy(linkText = "Mini Statement")
    private WebElement miniStatementMenu;

    @FindBy(linkText = "Customised Statement")
    private WebElement customisedStatementMenu;

    @FindBy(linkText = "Log out")
    private WebElement logoutMenu;

    public boolean isManagerHomePageDisplayed() {

        WaitUtils.waitForVisibility(managerIdLabel);

        return managerIdLabel.isDisplayed();
    }

    public void clickNewCustomer() {
        newCustomerMenu.click();
    }

    public void clickNewAccount() {
        newAccountMenu.click();
    }

    public void clickDeposit() {
        depositMenu.click();
    }

    public void clickWithdrawal() {
        withdrawalMenu.click();
    }

    public void clickFundTransfer() {
        fundTransferMenu.click();
    }

    public void clickChangePassword() {
        changePasswordMenu.click();
    }

    public void clickBalanceEnquiry() {
        balanceEnquiryMenu.click();
    }

    public void clickMiniStatement() {
        miniStatementMenu.click();
    }

    public void clickCustomisedStatement() {
        customisedStatementMenu.click();
    }

    public void logout() {
        logoutMenu.click();
    }
}