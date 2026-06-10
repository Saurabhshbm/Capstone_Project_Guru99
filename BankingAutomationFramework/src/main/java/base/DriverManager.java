package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
public class DriverManager {

    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static void initializeDriver(String browser) {

        switch (browser.toLowerCase()) {

        case "chrome":

            ChromeOptions options =
                    new ChromeOptions();

            if(System.getProperty("os.name")
                    .toLowerCase()
                    .contains("linux")) {

                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
            }

            driver.set(new ChromeDriver(options));
            break;
            
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;

            default:
                throw new RuntimeException(
                        "Unsupported Browser");
        }

        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        if(driver.get()!=null) {

            driver.get().quit();

            driver.remove();
        }
    }
}