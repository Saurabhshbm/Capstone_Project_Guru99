package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ConfigReader;
import utilities.TextContext;

public class BaseTest {

    @BeforeMethod
    public void setup() {

        DriverManager.initializeDriver(
                ConfigReader.getProperty("browser"));

        DriverManager.getDriver().get(
                ConfigReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {

        DriverManager.quitDriver();

        TextContext.setCustomerId(null);
        TextContext.setAccountId(null);
    }
}