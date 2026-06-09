package utilities;

import base.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String capture(String testName) {

        try {

            File source =
                    ((TakesScreenshot)
                            DriverManager.getDriver())
                            .getScreenshotAs(OutputType.FILE);

            String timestamp =
                    new SimpleDateFormat(
                            "yyyyMMddHHmmss")
                            .format(new Date());

            String destination =
                    "screenshots/"
                            + testName
                            + "_"
                            + timestamp
                            + ".png";

            FileUtils.copyFile(
                    source,
                    new File(destination));

            return destination;

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}