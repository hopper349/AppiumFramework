package Utils;

import Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities extends TestBase {


    public static String getSystemDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("_ddMMyyyy_HHmmss");
        Date date = new Date();
        String systemDate = dateFormat.format(date);
        return systemDate;
    }

    public static String captureScreenshot(String screenshotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String screenshotPath =  System.getProperty("user.dir") + "/Screenshots/" +screenshotName+ getSystemDate()+".png";
        FileUtils.copyFile(src,new File(screenshotPath));
        return screenshotPath;
    }
}
