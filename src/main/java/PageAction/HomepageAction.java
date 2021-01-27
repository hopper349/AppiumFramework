package PageAction;

import Base.TestBase;
import Pages.Homepage;
import Utils.Utilities;
import io.appium.java_client.android.AndroidDriver;

public class HomepageAction extends TestBase {

    AndroidDriver driver;
    Homepage homepage;

    public HomepageAction(AndroidDriver driver){
        this.driver= driver;
        homepage = new Homepage(this.driver);
    }


    public ProductsPageAction enterHomepageDetails(){
        homepage.getCountryDropdown().click();
        Utilities.scrollToElementUsingText("India");
        homepage.getCountry("India").click();
        homepage.getNameField().sendKeys("Dipanshu");
        homepage.getMaleRadioBtn().click();
        homepage.getLetsShopBtn().click();
        return new ProductsPageAction(driver);
    }

    public ProductsPageAction enterHomepageDetails2(){
        homepage.getCountryDropdown().click();
        Utilities.scrollToElementUsingText("Argentina");
        homepage.getCountry("Argentina").click();
        homepage.getNameField().sendKeys("Saini");
        homepage.getMaleRadioBtn().click();
        homepage.getLetsShopBtn().click();
        return new ProductsPageAction(driver);
    }

}
