package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private Faker faker;
    private final String VALIDUSER="admin@admin.com";

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        faker=new Faker();
    }

    @BeforeMethod
    @Override
    public void beforMethod() {
        super.beforMethod();
        homePage.loginButtonClick();
    }

    @Test
    public void visitsTheLoginPage() {

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://vue-demo.daniel-avellaneda.com/login";
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
        Assert.assertEquals(actualMessage,expectedMessage);
        Assert.assertEquals(driver.getCurrentUrl(),"https://vue-demo.daniel-avellaneda.com/login");

    }

    @Test
    public void displaysErrorsWhenPasswordIsWrong() {

        loginPage.fillLogIn(VALIDUSER, faker.internet().password());
        String actualMessage=loginPage.getMessage().getText();
        String expectedMessage="Wrong password";
        Assert.assertEquals(actualMessage, expectedMessage);
        Assert.assertEquals(driver.getCurrentUrl(),"https://vue-demo.daniel-avellaneda.com/login");

    }
}
