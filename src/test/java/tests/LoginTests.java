package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    private LoginPage loginPage;


    @BeforeClass
    @Override
    public void beforeClass() { 
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.loginButtonClick();
    }

    @Test
    public void visitsTheLoginPage() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = baseUrl + "/login";
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test
    public void checksInputTypes() {
        String actualEmailType = loginPage.getEmail().getAttribute("type");
        String expectedEmailType = "email";
        Assert.assertEquals(actualEmailType, expectedEmailType);

        String actualPasswordType = loginPage.getPassword().getAttribute("type");
        String expectedPasswordType = "password";
        Assert.assertEquals(actualPasswordType, expectedPasswordType);
    }

    @Test
    public void displaysErrorsWhenUserDoesNotExist() {

        loginPage.fillLogIn(faker.internet().emailAddress(), faker.internet().password());
        String actualMessage = loginPage.getMessage().getText();
        String expectedMessage = "User does not exists";
        Assert.assertEquals(actualMessage, expectedMessage);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
    }

    @Test
    public void displaysErrorsWhenPasswordIsWrong() {
        loginPage.fillLogIn(VALIDEMAIL, faker.internet().password());
        String actualMessage = loginPage.getMessage().getText();
        String expectedMessage = "Wrong password";
        Assert.assertEquals(actualMessage, expectedMessage);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
    }

    @Test
    public void login() {
        loginPage.fillLogIn(VALIDEMAIL, VALIDPASSWORD);
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/home");
    }

    @Test
    public void logout() {
        loginPage.fillLogIn(VALIDEMAIL, VALIDPASSWORD);
        Assert.assertTrue(homePage.isLogoutButtonVisible());
        homePage.getLogoutButton().click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
        driver.get(baseUrl + "/home");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
    }

}
