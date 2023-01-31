package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
   private HomePage homePage;
    private LoginPage loginPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage=new HomePage(driver,driverWait);
        loginPage=new LoginPage(driver, driverWait);
    }

    @Test
    public void visitsTheLoginPage() {

        homePage.loginButtonClick();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl ="https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(actualUrl, expectedUrl);

    }

    @Test
    public void checksInputTypes() {
        homePage.loginButtonClick();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String actualEmailType=loginPage.getEmail().getAttribute("type");
        String expectedEmailType= "email";
        Assert.assertEquals(actualEmailType, expectedEmailType);

        String actualPasswordType=loginPage.getPassword().getAttribute("type");
        String expectedPasswordType="password";
        Assert.assertEquals(actualPasswordType, expectedPasswordType);

    }
}
