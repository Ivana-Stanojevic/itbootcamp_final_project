package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends BaseTest {
    HomePage homePage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage=new HomePage(driver,driverWait);
    }

    @Test
    public void visitsTheLoginPage() {
        homePage.loginButtonClick();
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl ="https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(actualUrl, expectedUrl);

    }
}
