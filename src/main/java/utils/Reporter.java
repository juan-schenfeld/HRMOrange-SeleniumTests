package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class Reporter {

    private static ExtentReports extentReports;

    public Reporter(String reportName) {
        if (extentReports == null) {
            extentReports = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/" + reportName + ".html");
            extentReports.attachReporter(sparkReporter);
        }
    }

    public ExtentTest newTest(String name, String description) {
        return extentReports.createTest(name, description);
    }

    public void closeTest() {
        extentReports.flush();
    }
}


