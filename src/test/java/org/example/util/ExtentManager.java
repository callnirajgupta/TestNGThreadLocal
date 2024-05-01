package org.example.util;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
        public static final ExtentReports extentReports = new ExtentReports();
        public synchronized static ExtentReports createExtentReports() {
            ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");

            reporter.config().setReportName("Sample Extent Report");
            reporter.config().setDocumentTitle("Title of the Report Comes here ");
            // Name of the report
            reporter.config().setReportName("Name of the Report Comes here ");
            // Dark Theme
            reporter.config().setTheme(Theme.STANDARD);
            extentReports.attachReporter(reporter);
            extentReports.setSystemInfo("Blog Name", "Robotic pro");
            extentReports.setSystemInfo("Author", "Niraj Gupta");
            return extentReports;
        }
    }

