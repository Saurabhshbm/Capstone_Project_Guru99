package utilities;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {

        if(extent == null) {
        	
        	System.out.println("Extent Report Initialized");

            ExtentSparkReporter spark =
                    new ExtentSparkReporter(
                            "reports/ExtentReport.html");

            spark.config().setReportName(
                    "Banking Automation Report");

            spark.config().setDocumentTitle(
                    "Guru99 Automation");

            extent = new ExtentReports();

            extent.attachReporter(spark);
        }

        return extent;
    }
}