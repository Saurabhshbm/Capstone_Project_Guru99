package pages.guru99;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WaitUtils;

public class LoginPage extends BasePage {

    private static final Logger logger =
            LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "uid")
    private WebElement userIdTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "btnLogin")
    private WebElement loginBtn;

    public boolean isLoginPageDisplayed() {

        logger.info("Verifying Login Page");

        return userIdTxt.isDisplayed();
    }

    public void enterUserId(String userId) {

        logger.info("Entering User ID");

        WaitUtils.waitForVisibility(userIdTxt);

        userIdTxt.clear();

        userIdTxt.sendKeys(userId);
    }

    public void enterPassword(String password) {

        logger.info("Entering Password");

        WaitUtils.waitForVisibility(passwordTxt);

        passwordTxt.clear();

        passwordTxt.sendKeys(password);
    }

    public void clickLogin() {

        logger.info("Clicking Login Button");

        WaitUtils.waitForClickable(loginBtn);

        loginBtn.click();
    }

    public void login(
            String userId,
            String password) {

        logger.info("Starting Login Process");

        enterUserId(userId);

        enterPassword(password);

        clickLogin();

        logger.info("Login Process Completed");
    }
}