package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class SignupTests extends BaseTest {

    private HomePage homePage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.getSingUpButton().click();

    }

    @Test
    public void visitsTheSignupPage() {
        String actualSignup = driver.getCurrentUrl();
        String expectSignup = baseUrl + "/signup";
        Assert.assertEquals(actualSignup, expectSignup);
    }
}
