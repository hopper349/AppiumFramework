package Homepage;


/* This test will verify the functionality of the Homepage. */

import Base.TestBase;
import PageAction.HomepageAction;
import PageAction.ProductsPageAction;
import Pages.Homepage;
import Pages.Productspage;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class Auto1 extends TestBase {

    AndroidDriver driver;
    HomepageAction homepageAction;
    ProductsPageAction productsPageAction;

    public Auto1(){
        super();
    }

    @BeforeMethod(groups = {"regression","smoke"})
    public void setUp() throws IOException {
        this.driver = initialization("appName");
        homepageAction = new HomepageAction(driver);
    }
    @AfterMethod(groups = {"regression","smoke"})
    public void tearDown(){
        driver.closeApp();
    }
    @Test(groups = {"regression"})
    public void validateHomePage() throws IOException {
        extentTest.info("Entering Homepage Details");
        homepageAction.enterHomepageDetails();
    }
    @Test(groups = {"smoke"})
    public void validateHomePage2(){
        extentTest.info("Entering Homepage Details");
        homepageAction.enterHomepageDetails2();
    }
}
