package testcases;

import base.BaseTest;
import base.DriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameworkValidationTest
        extends BaseTest {

    @Test
    public void verifyFrameworkSetup() {

        String title =
                DriverManager.getDriver()
                        .getTitle();

        Assert.assertTrue(
                title.contains("Guru99"));
    }
}