package PageAction;

import Base.TestBase;
import Pages.Homepage;
import io.appium.java_client.android.AndroidDriver;

public class HomepageAction extends TestBase {

    AndroidDriver driver;
    Homepage homepage;

    public HomepageAction(AndroidDriver driver){
        this.driver= driver;
        homepage = new Homepage(this.driver);
    }


    public ProductsPageAction enterHomepageDetails(){
        homepage.getCountryDropdown().sendKeys("India");
        homepage.getNameField().sendKeys("Dipanshu");
        homepage.getMaleRadioBtn().click();
        homepage.getLetsShopBtn().click();
        return new ProductsPageAction(driver);
    }

}
