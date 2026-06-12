package testcases.guru99;

import base.BaseTest;
import base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.guru99.HomePage;
import pages.guru99.LoginPage;
import utilities.ConfigReader;
import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @Test
    public void verifyInvalidLogin() {

        LoginPage loginPage =
                new LoginPage(
                        DriverManager.getDriver());

        loginPage.login(
                "invalidUser",
                "invalidPassword");

        WebDriverWait wait =
                new WebDriverWait(
                        DriverManager.getDriver(),
                        Duration.ofSeconds(10));

        Alert alert =
                wait.until(
                        ExpectedConditions.alertIsPresent());

        String alertText =
                alert.getText();

        System.out.println(
                "Alert Message = "
                        + alertText);

        Assert.assertTrue(
                alertText.contains("not valid"),
                "Invalid login message not displayed");

        alert.accept();
    }
    
    
    
    @Test
    public void verifyEmptyLogin() {

        LoginPage loginPage =
                new LoginPage(
                        DriverManager.getDriver());

        loginPage.login(
                "",
                "");

        WebDriverWait wait =
                new WebDriverWait(
                        DriverManager.getDriver(),
                        Duration.ofSeconds(10));

        Alert alert =
                wait.until(
                        ExpectedConditions.alertIsPresent());

        String alertText =
                alert.getText();

        System.out.println(
                "Alert Message = "
                        + alertText);

        Assert.assertTrue(
                alertText.length() > 0,
                "Expected alert message not displayed");

        alert.accept();
    }
}