package pages.guru99;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.WaitUtils;

public class MiniStatementPage extends BasePage {

    public MiniStatementPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "accountno")
    private WebElement accountNumberTxt;

    @FindBy(name = "AccSubmit")
    private WebElement submitBtn;

    public void getMiniStatement(String accountNumber) {

        accountNumberTxt.clear();
        accountNumberTxt.sendKeys(accountNumber);

        WaitUtils.waitForClickable(submitBtn);

        submitBtn.click();
    }
}