package utilities;

import base.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtils {

    private static final int TIMEOUT = 15;

    public static void waitForVisibility(
            WebElement element) {

        WebDriverWait wait =
                new WebDriverWait(
                        DriverManager.getDriver(),
                        Duration.ofSeconds(TIMEOUT));

        wait.until(
                ExpectedConditions.visibilityOf(element));
    }

    public static void waitForClickable(
            WebElement element) {

        WebDriverWait wait =
                new WebDriverWait(
                        DriverManager.getDriver(),
                        Duration.ofSeconds(TIMEOUT));

        wait.until(
                ExpectedConditions.elementToBeClickable(element));
    }
}