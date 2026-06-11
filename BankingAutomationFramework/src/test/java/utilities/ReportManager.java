package utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if (extent == null) {

            System.out.println("Extent Report Initialized");

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "reports/ExtentReport.html");

            spark.config().setReportName(
                    "Guru99 Banking Automation Framework");

            spark.config().setDocumentTitle(
                    "Banking Automation Report");

            extent = new ExtentReports();

            extent.attachReporter(spark);

            // Project Details
            extent.setSystemInfo(
                    "Project Name",
                    "Banking Automation Framework");

            extent.setSystemInfo(
                    "Tester",
                    "Saurabh Kumar");

            extent.setSystemInfo(
                    "Browser",
                    ConfigReader.getProperty("browser"));

            extent.setSystemInfo(
                    "Environment",
                    "QA");

            extent.setSystemInfo(
                    "Framework",
                    "Selenium + TestNG + Maven");

            extent.setSystemInfo(
                    "CI/CD",
                    "Jenkins");

            extent.setSystemInfo(
                    "Containerization",
                    "Docker");

            extent.setSystemInfo(
                    "OS",
                    System.getProperty("os.name"));

            extent.setSystemInfo(
                    "Java Version",
                    System.getProperty("java.version"));
        }

        return extent;
    }
}