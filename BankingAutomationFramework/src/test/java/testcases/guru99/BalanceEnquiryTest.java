package testcases.guru99;

import base.BaseTest;
import base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import pages.guru99.BalanceEnquiryPage;
import pages.guru99.HomePage;
import pages.guru99.LoginPage;
import utilities.ConfigReader;
import utilities.TestContext;
@Ignore
public class BalanceEnquiryTest extends BaseTest {

    @Test
    public void verifyBalanceEnquiryNavigation() {

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
                homePage.isManagerHomePageDisplayed());

        homePage.clickBalanceEnquiry();

        BalanceEnquiryPage balancePage =
                new BalanceEnquiryPage(
                        DriverManager.getDriver());

        balancePage.searchAccount(
                TestContext.getAccountId());

        Assert.assertTrue(true);
    }
}