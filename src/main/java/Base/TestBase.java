package Base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import javafx.print.PageOrientation;
import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class TestBase {


    public static AndroidDriver<AndroidElement> driver;
    public static ExtentReports extentReports;
    public static ExtentSparkReporter extentSparkReporter;
    public static ExtentTest extentTest;
    public static Properties properties;
    public static Logger Log;

    public TestBase(){
        Log = Logger.getLogger(this.getClass());
        try{
            String propertiesFilePath= System.getProperty("user.dir")+"\\src\\main\\resources\\global.properties";
            FileInputStream fis = new FileInputStream(propertiesFilePath);
            properties = new Properties();
            properties.load(fis);
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {


        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\global.properties");
        Properties properties = new Properties();
        properties.load(fis);

        String appDir = System.getProperty("user.dir")+"\\Apps\\"+properties.getProperty(appName);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP,appDir);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,properties.getProperty("device"));

        driver= new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
