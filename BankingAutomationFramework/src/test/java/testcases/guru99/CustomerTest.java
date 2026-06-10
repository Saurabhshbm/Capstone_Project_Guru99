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
import utilities.ExcelUtils;
import utilities.RandomDataGenerator;
import utilities.TestContext;
import utilities.TestDataProvider;

public class CustomerTest extends BaseTest {

    @Test(
            dataProvider = "customerData",
            dataProviderClass =
                    TestDataProvider.class)
    public void verifyCustomerCreation(

            String customerName,
            String dob,
            String address,
            String city,
            String state,
            String pin,
            String password) {

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
                customerName,
                dob,
                address,
                city,
                state,
                pin,
                RandomDataGenerator.generateMobile(),
                RandomDataGenerator.generateEmail(),
                password);

        CustomerSuccessPage successPage =
                new CustomerSuccessPage(
                        DriverManager.getDriver());

        String customerId =
                successPage.getCustomerId();

        Assert.assertNotNull(customerId);

        System.out.println(
                "Customer Created : "
                        + customerId);
    }
}