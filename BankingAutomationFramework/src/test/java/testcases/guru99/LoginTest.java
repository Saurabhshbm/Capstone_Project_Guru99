package testcases.guru99;

import base.BaseTest;
import base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.guru99.HomePage;
import pages.guru99.LoginPage;
import utilities.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void verifyValidLogin() {

        LoginPage loginPage =
                new LoginPage(
                        DriverManager.getDriver());

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        HomePage homePage =
                new HomePage(
                        DriverManager.getDriver());

        Assert.assertTrue(
                homePage.isManagerHomePageDisplayed(),
                "Login Failed");
    }
}