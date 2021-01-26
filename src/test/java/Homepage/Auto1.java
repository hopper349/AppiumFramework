package Homepage;


/* This test will verify the functionality of the Homepage. */

import Base.TestBase;
import PageAction.HomepageAction;
import PageAction.ProductsPageAction;
import Pages.Homepage;
import Pages.Productspage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Auto1 extends TestBase {

    AndroidDriver driver;
    Homepage homepage;
    HomepageAction homepageAction;
    Productspage productspage;
    ProductsPageAction productsPageAction;

    @BeforeTest
    public void setUp() throws IOException {
        this.driver = capabilities("appName");
        homepage = new Homepage(driver);
        productspage = new Productspage(driver);
        homepageAction = new HomepageAction(driver);
    }

    @Test
    public void validateHomePage(){
        //productsPageAction = homepageAction.enterHomepageDetails();
        Assert.assertTrue(homepage.getMaleRadioBtn().isDisplayed());
    }

}
