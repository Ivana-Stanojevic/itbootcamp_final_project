package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignupPage;

public class SignupTests extends BaseTest {

    private SignupPage signupPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        signupPage = new SignupPage(driver, driverWait);

    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.getSingUpButton().click();

    }

    @Test
    public void visitsTheSignupPage() {
        driverWait.until(ExpectedConditions.urlContains("/signup"));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup");
    }

    @Test
    public void checksInputTypes() {
        Assert.assertEquals(signupPage.getEmail().getAttribute("type"), "email");
        Assert.assertEquals(signupPage.getPassword().getAttribute("type"), "password");
        Assert.assertEquals(signupPage.getConfirmPassword().getAttribute("type"), "password");

    }

    @Test
    public void displaysErrorsWhenUserAlreadyExists() {
        signupPage.fillSignUp("Test Test", "admin@admin.com", "123654", "123654");
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getMessage()));
        Assert.assertEquals(signupPage.getMessage().getText(), "E-mail already exists");
        driverWait.until(ExpectedConditions.urlContains("/signup"));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/signup");

    }

    @Test
    public void signup() {
        signupPage.fillSignUp(faker.name().fullName(), faker.internet().emailAddress(), "555333", "555333");
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getMessageImportant()));
        Assert.assertEquals(signupPage.getMessageImportant().getText(), "IMPORTANT: Verify your account");
        signupPage.getCloseButton().click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       signupPage.getLogoutButton().click();

    }
}
