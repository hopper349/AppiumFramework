package Pages;

import Base.TestBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Homepage extends TestBase {

    AndroidDriver<WebElement> driver;

    public Homepage(AndroidDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath="//android.widget.Spinner[@resource-id='com.androidsample.generalstore:id/spinnerCountry']")
    private WebElement CountryDropdown;

    @AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.androidsample.generalstore:id/nameField']")
    private WebElement NameField;

    @AndroidFindBy(xpath="//android.widget.RadioButton[@resource-id='com.androidsample.generalstore:id/radioMale']")
    private WebElement MaleRadioBtn;

    @AndroidFindBy(xpath="//android.widget.Button[@text='Let's  Shop']")
    private WebElement LetsShopBtn;

    public WebElement getCountryDropdown(){
        return CountryDropdown;
    }
    public WebElement getNameField(){
        return NameField;
    }
    public WebElement getMaleRadioBtn(){
        return MaleRadioBtn;
    }
    public WebElement getLetsShopBtn(){
        return LetsShopBtn;
    }
}
