package Pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class Productspage {

    AndroidDriver driver;

    public Productspage(AndroidDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
}
