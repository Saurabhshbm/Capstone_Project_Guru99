package listeners;

import com.aventstack.extentreports.*;
import org.testng.*;
import utilities.ReportManager;
import utilities.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static ExtentReports extent =
            ReportManager.getReportInstance();

    private static ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("Listener Triggered");

        test.set(
            extent.createTest(
                result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(
            ITestResult result) {

        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(
            ITestResult result) {

        String screenshotPath =
                ScreenshotUtils.capture(
                        result.getMethod().getMethodName());

        test.get().fail(result.getThrowable());

        test.get().addScreenCaptureFromPath(
                screenshotPath);
    }

    @Override
    public void onFinish(
            ITestContext context) {

        extent.flush();
    }
}