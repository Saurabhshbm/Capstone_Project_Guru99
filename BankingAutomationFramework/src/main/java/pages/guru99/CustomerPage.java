package pages.guru99;

import base.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WaitUtils;
import org.openqa.selenium.Keys;

public class CustomerPage extends BasePage {

    private static final Logger logger =
            LogManager.getLogger(CustomerPage.class);

    public CustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "name")
    private WebElement customerNameTxt;
    
    @FindBy(xpath = "//input[@value='m']")
    private WebElement maleRadioBtn;

    @FindBy(id = "dob")
    private WebElement dobTxt;

    @FindBy(name = "addr")
    private WebElement addressTxt;

    @FindBy(name = "city")
    private WebElement cityTxt;

    @FindBy(name = "state")
    private WebElement stateTxt;

    @FindBy(name = "pinno")
    private WebElement pinTxt;

    @FindBy(name = "telephoneno")
    private WebElement mobileTxt;

    @FindBy(name = "emailid")
    private WebElement emailTxt;

    @FindBy(name = "password")
    private WebElement passwordTxt;

    @FindBy(name = "sub")
    private WebElement submitBtn;

    public void createCustomer(
            String name,
            String dob,
            String address,
            String city,
            String state,
            String pin,
            String mobile,
            String email,
            String password) {

        logger.info("Creating Customer");

        WaitUtils.waitForVisibility(customerNameTxt);

        customerNameTxt.sendKeys(name);
        System.out.println("Name Entered");

        maleRadioBtn.click();
        System.out.println("Gender Selected");

        dobTxt.sendKeys(Keys.CONTROL + "a");
        dobTxt.sendKeys(Keys.DELETE);
        dobTxt.sendKeys("01011998");
        System.out.println("DOB Entered");

        addressTxt.sendKeys(address);
        System.out.println("Address Entered");

        cityTxt.sendKeys(city);
        System.out.println("City Entered");

        stateTxt.sendKeys(state);
        System.out.println("State Entered");

        pinTxt.sendKeys(pin);
        System.out.println("PIN Entered");

        mobileTxt.sendKeys(mobile);
        System.out.println("Mobile Entered");

        emailTxt.sendKeys(email);
        System.out.println("Email Entered");

        passwordTxt.sendKeys(password);
        System.out.println("Password Entered");

        WaitUtils.waitForClickable(submitBtn);
        
        System.out.println("Name = " + customerNameTxt.getAttribute("value"));
        System.out.println("DOB = " + dobTxt.getAttribute("value"));
        System.out.println("Address = " + addressTxt.getAttribute("value"));
        System.out.println("City = " + cityTxt.getAttribute("value"));
        System.out.println("State = " + stateTxt.getAttribute("value"));
        System.out.println("PIN = " + pinTxt.getAttribute("value"));
        System.out.println("Mobile = " + mobileTxt.getAttribute("value"));
        System.out.println("Email = " + emailTxt.getAttribute("value"));
        System.out.println("Password = " + passwordTxt.getAttribute("value"));

        submitBtn.click();
    }
}