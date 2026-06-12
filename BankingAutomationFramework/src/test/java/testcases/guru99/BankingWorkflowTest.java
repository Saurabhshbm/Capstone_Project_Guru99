package testcases.guru99;

import base.BaseTest;
import base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.guru99.*;
import utilities.ConfigReader;
import utilities.RandomDataGenerator;
import org.testng.annotations.Listeners;
import listeners.TestListener;

@Listeners(TestListener.class)


public class BankingWorkflowTest extends BaseTest {

    @Test
    public void completeBankingWorkflow() throws InterruptedException {

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

        // CUSTOMER CREATION

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
                "Customer ID = "
                        + customerId);

        // ACCOUNT CREATION

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

        String account1 =
                accountSuccessPage.getAccountId();

        System.out.println(
                "Account 1 = "
                        + account1);
        homePage =
                new HomePage(
                        DriverManager.getDriver());

        homePage.clickNewAccount();

        accountPage =
                new AccountPage(
                        DriverManager.getDriver());

        accountPage.createAccount(
                customerId,
                "Savings",
                "3000");

        accountSuccessPage =
                new AccountSuccessPage(
                        DriverManager.getDriver());

        String account2 =
                accountSuccessPage.getAccountId();

        System.out.println(
                "Account 2 = " + account2);
        
        homePage =
                new HomePage(
                        DriverManager.getDriver());

        homePage.clickNewAccount();

        accountPage =
                new AccountPage(
                        DriverManager.getDriver());

        accountPage.createAccount(
                customerId,
                "Savings",
                "3000");

        accountSuccessPage =
                new AccountSuccessPage(
                        DriverManager.getDriver());

        String account2f =
                accountSuccessPage.getAccountId();

        System.out.println(
                "Account 2 = " + account2);
        
        homePage =
                new HomePage(
                        DriverManager.getDriver());

        homePage.clickFundTransfer();

        FundTransferPage fundTransferPage =
                new FundTransferPage(
                        DriverManager.getDriver());

        fundTransferPage.transferFund(
                account1,
                account2,
                "500",
                "Transfer");
        FundTransferSuccessPage fundTransferSuccessPage =
                new FundTransferSuccessPage(
                        DriverManager.getDriver());

        Assert.assertTrue(
                fundTransferSuccessPage
                        .isFundTransferSuccessful());

        fundTransferSuccessPage
                .printFundTransferDetails();

        System.out.println(
                "Fund Transfer Completed");
        
        

        
        
        homePage =
                new HomePage(
                        DriverManager.getDriver());

        homePage.clickWithdrawal();

        WithdrawalPage withdrawalPage =
                new WithdrawalPage(
                        DriverManager.getDriver());

        withdrawalPage.withdrawAmount(
                account1,
                "100",
                "ATM");
        WithdrawalSuccessPage withdrawalSuccessPage =
                new WithdrawalSuccessPage(
                        DriverManager.getDriver());

        Assert.assertTrue(
                withdrawalSuccessPage.isWithdrawalSuccessful());

        withdrawalSuccessPage.printWithdrawalDetails();
        
        try {

            homePage.clickDeposit();

            DepositPage depositPage =
                    new DepositPage(
                            DriverManager.getDriver());

            depositPage.depositAmount(
                    account1,
                    "1000",
                    "Cash Deposit");

            Thread.sleep(3000);

        } catch (Exception e) {

            System.out.println(
                    "Deposit Failed : "
                            + e.getMessage());
        }
        
        

        System.out.println(
                "Navigating back to Home Page");

        DriverManager.getDriver().navigate().back();

        Thread.sleep(2000);

        DriverManager.getDriver().get(
                "https://demo.guru99.com/V4/manager/Logout.php");

        try {

            DriverManager.getDriver()
                    .switchTo()
                    .alert()
                    .accept();

            System.out.println(
                    "Logout Successful");

        } catch (Exception e) {

            System.out.println(
                    "Logout Alert Not Found");
        }

    }
}