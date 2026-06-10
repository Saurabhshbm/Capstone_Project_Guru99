package testcases.guru99;

import base.BaseTest;
import base.DriverManager;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.guru99.ChangePasswordPage;
import pages.guru99.HomePage;
import pages.guru99.LoginPage;
import utilities.ConfigReader;
@Ignore
public class ChangePasswordTest extends BaseTest {

    @Test
    public void verifyChangePasswordPage() {

        LoginPage loginPage =
                new LoginPage(
                        DriverManager.getDriver());

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        HomePage homePage =
                new HomePage(
                        DriverManager.getDriver());

        homePage.clickChangePassword();

        ChangePasswordPage changePasswordPage =
                new ChangePasswordPage(
                        DriverManager.getDriver());

        changePasswordPage.changePassword(
                ConfigReader.getProperty("password"),
                "Temp@123");
    }
}