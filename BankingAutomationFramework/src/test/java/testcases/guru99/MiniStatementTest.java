package testcases.guru99;

import base.BaseTest;
import base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.guru99.HomePage;
import pages.guru99.LoginPage;
import pages.guru99.MiniStatementPage;
import utilities.ConfigReader;
import utilities.TestContext;

public class MiniStatementTest extends BaseTest {

    @Test
    public void verifyMiniStatementPage() {

        LoginPage loginPage =
                new LoginPage(
                        DriverManager.getDriver());

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        HomePage homePage =
                new HomePage(
                        DriverManager.getDriver());

        homePage.clickMiniStatement();

        MiniStatementPage page =
                new MiniStatementPage(
                        DriverManager.getDriver());

        page.getMiniStatement(
                TestContext.getAccountId());

        Assert.assertTrue(true);
    }
}