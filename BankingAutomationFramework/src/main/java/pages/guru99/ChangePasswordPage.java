package pages.guru99;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WaitUtils;

public class ChangePasswordPage extends BasePage {

    private static final Logger logger =
            LogManager.getLogger(ChangePasswordPage.class);

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "oldpassword")
    private WebElement oldPasswordTxt;

    @FindBy(name = "newpassword")
    private WebElement newPasswordTxt;

    @FindBy(name = "confirmpassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name = "sub")
    private WebElement submitBtn;

    public void changePassword(
            String oldPassword,
            String newPassword) {

        logger.info("Changing Password");

        oldPasswordTxt.clear();
        oldPasswordTxt.sendKeys(oldPassword);

        newPasswordTxt.clear();
        newPasswordTxt.sendKeys(newPassword);

        confirmPasswordTxt.clear();
        confirmPasswordTxt.sendKeys(newPassword);

        WaitUtils.waitForClickable(submitBtn);

        submitBtn.click();
    }
}