package org.example.util.listener;

import com.aventstack.extentreports.Status;
import org.example.test.BaseTest;
import org.example.util.ExtentManager;
import org.example.util.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Objects;

import static org.example.util.ExtentTestManager.getTest;

public class TestListener extends BaseTest implements ITestListener {

        private static String getTestMethodName(ITestResult iTestResult) {
                return iTestResult.getMethod().getConstructorOrMethod().getName();
        }
        @Override
        public void onFinish(ITestContext Result)
        {
                //Log.info("I am in onFinish method " + iTestContext.getName());
                Log.info("I am in onFinish method ");
                //Do tier down operations for ExtentReports reporting!
                ExtentManager.extentReports.flush();

        }

        @Override
        public void onStart(ITestContext Result)
        {
                Log.info("I am in onStart method "  );
               // iTestContext.setAttribute("WebDriver", getDriver());

        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult Result){
                // Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
            Log.info("Test failed but it is in defined success ratio " );

        }

        // When Test case get failed, this method is called.
        @Override
        public void onTestFailure(ITestResult Result)
        {
            System.out.println("The name of the testcase failed is :"+Result.getName());
               // Log.info(getTestMethodName(iTestResult) + " test is failed.");
                Log.info(" test is failed.");
                //Get driver from BaseTest and assign to local webdriver variable.
                //Object testClass = iTestResult.getInstance();
                WebDriver driver = getDriver();
                //Take base64Screenshot screenshot for extent reports
                String base64Screenshot =
                        "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);
                //ExtentReports log and screenshot operations for failed tests.
                getTest().log(Status.FAIL, "Test Failed",
                        getTest().addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
        }

        // When Test case get Skipped, this method is called.
        @Override
        public void onTestSkipped(ITestResult Result)
        {
            System.out.println("The name of the testcase Skipped is :"+Result.getName());
               // Log.info(getTestMethodName(iTestResult) + " test is skipped.");
                Log.info(" test is skipped.");
                //ExtentReports log operation for skipped tests.
                getTest().log(Status.SKIP, "Test Skipped");
        }

        // When Test case get Started, this method is called.
        @Override
        public void onTestStart(ITestResult Result)
        {

                System.out.println(Result.getName()+" test case started");
                //Log.info(getTestMethodName(iTestResult) + " test is starting.");
                Log.info( " test is starting.");
        }

        // When Test case get passed, this method is called.
        @Override
        public void onTestSuccess(ITestResult Result)
        {
            System.out.println("The name of the testcase passed is :"+Result.getName());
               // Log.info(getTestMethodName(iTestResult) + " test is succeed.");
            Log.info(" test is succeed.");
                //ExtentReports log operation for passed tests.
                getTest().log(Status.PASS, "Test passed");
        }

    }

