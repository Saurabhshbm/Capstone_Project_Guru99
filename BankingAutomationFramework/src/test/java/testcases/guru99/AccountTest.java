package testcases.guru99;

import base.BaseTest;
import base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.guru99.*;
import utilities.ConfigReader;
import utilities.RandomDataGenerator;
import utilities.TestContext;

public class AccountTest extends BaseTest {

    @Test
    public void verifyAccountCreation() {

        LoginPage loginPage =
                new LoginPage(
                        DriverManager.getDriver());

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        HomePage homePage =
                new HomePage(
                        DriverManager.getDriver());

        homePage.clickNewCustomer();

        CustomerPage customerPage =
                new CustomerPage(
                        DriverManager.getDriver());

        customerPage.createCustomer(
                "Saurabh Kumar",
                "1998-01-01",
                "Ranchi Main Road",
                "Ranchi",
                "Jharkhand",
                "834001",
                RandomDataGenerator.generateMobile(),
                RandomDataGenerator.generateEmail(),
                "Test@123");

        CustomerSuccessPage customerSuccessPage =
                new CustomerSuccessPage(
                        DriverManager.getDriver());

        String customerId =
                customerSuccessPage.getCustomerId();
        
        System.out.println(
        	    "Customer ID From Context = "
        	    + TestContext.getCustomerId());

        homePage =
                new HomePage(
                        DriverManager.getDriver());
        

        homePage.clickNewAccount();

        AccountPage accountPage =
                new AccountPage(
                        DriverManager.getDriver());

        accountPage.createAccount(
                customerId,
                "Savings",
                "5000");

        AccountSuccessPage accountSuccessPage =
                new AccountSuccessPage(
                        DriverManager.getDriver());

        String accountId =
                accountSuccessPage.getAccountId();

        Assert.assertNotNull(accountId);

        System.out.println(
                "Generated Account ID : "
                        + accountId);

        System.out.println(
                "Stored Account ID : "
                        + TestContext.getAccountId());
    }
}