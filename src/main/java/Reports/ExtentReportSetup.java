package Reports;

import Base.TestBase;
import Utils.Utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportSetup extends TestBase {


    public static ExtentReports setupExtentReport() {
        String testReportPath = System.getProperty("user.dir") + "\\TestReports\\AppiumReport" + Utilities.getSystemDate() + ".html";
        extentReports = new ExtentReports();
        extentSparkReporter = new ExtentSparkReporter(testReportPath);
        extentReports.attachReporter(extentSparkReporter);

        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setDocumentTitle("Appium Test Report");
        extentSparkReporter.config().setReportName("Automation Report");
        return extentReports;

    }

}
