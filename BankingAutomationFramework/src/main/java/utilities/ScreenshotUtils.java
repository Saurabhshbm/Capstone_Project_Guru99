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

            String folderPath = "screenshots";

            File folder = new File(folderPath);

            if (!folder.exists()) {

                folder.mkdirs();
            }

            String destination =
                    new File(
                            folderPath,
                            testName + "_"
                                    + timestamp
                                    + ".png")
                            .getAbsolutePath();

            FileUtils.copyFile(
                    source,
                    new File(destination));
            
            System.out.println(
                    "Screenshot Saved At : "
                            + destination);

            return destination;

        } catch (Exception e) {
        	
        	e.printStackTrace();
        	
        	

            //throw new RuntimeException(e);
        }
		return testName;
    }
}