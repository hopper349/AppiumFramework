package TestListener;

import Base.TestBase;
import Reports.ExtentReportSetup;
import Utils.Utilities;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;

public class ExtentReportListener extends TestBase implements ITestListener {

    public void onTestStart(ITestResult result) {
        extentTest = extentReports.createTest(result.getMethod().getMethodName());
        extentTest.info("Starting the test :"+ result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        extentTest.pass("Test " + result.getMethod().getMethodName() +" PASSED");
    }

    public void onTestFailure(ITestResult result) {
        extentTest.fail("Test "  + result.getMethod().getMethodName() +" FAILED");
        extentTest.fail(result.getThrowable());
        try{
            extentTest.addScreenCaptureFromPath(Utilities.captureScreenshot(result.getMethod().getMethodName()));
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        // not implemented
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        extentReports = ExtentReportSetup.setupExtentReport();
    }

    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

}
