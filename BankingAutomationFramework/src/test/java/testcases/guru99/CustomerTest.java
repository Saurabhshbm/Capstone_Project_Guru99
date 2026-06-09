package testcases.guru99;

import base.BaseTest;
import base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.guru99.CustomerPage;
import pages.guru99.CustomerSuccessPage;
import pages.guru99.HomePage;
import pages.guru99.LoginPage;
import utilities.ConfigReader;
import utilities.RandomDataGenerator;
import utilities.TestContext;

public class CustomerTest extends BaseTest {

    @Test
    public void verifyCustomerCreation() {

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
                "Ranchi",
                "Ranchi",
                "Jharkhand",
                "834001",
                RandomDataGenerator.generateMobile(),
                RandomDataGenerator.generateEmail(),
                "Test@123");

        CustomerSuccessPage successPage =
                new CustomerSuccessPage(
                        DriverManager.getDriver());

        String customerId =
                successPage.getCustomerId();

        Assert.assertNotNull(customerId);

        System.out.println(
                "Generated Customer ID : "
                        + customerId);

        System.out.println(
                "Stored Customer ID : "
                        + TestContext.getCustomerId());
    }
}