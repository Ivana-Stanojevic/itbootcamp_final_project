package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignupPage;

public class SignupTests extends BaseTest {

    private HomePage homePage;
    private SignupPage signupPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        signupPage=new SignupPage(driver,driverWait);
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

    @Test
    public void checksInputTypes() {
        Assert.assertEquals(signupPage.getEmail().getAttribute("type"), "email");
        Assert.assertEquals(signupPage.getPassword().getAttribute("type"), "password");
        Assert.assertEquals(signupPage.getConfirmPassword().getAttribute("type"), "password");

    }
}
