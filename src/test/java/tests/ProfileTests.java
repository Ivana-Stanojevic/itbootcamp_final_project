package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePages;
import pages.SignupPage;

public class ProfileTests extends BaseTest {
    private HomePage homePage;
    private LoginPage loginPage;
    private ProfilePages profilePages;
    private SignupPage signupPage;
    private String name;
    private String phoneNumber;
    private String country;
    private String city;
    private String urlTwitter;
    private String urlGitHub;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        profilePages = new ProfilePages(driver, driverWait);
        signupPage=new SignupPage(driver, driverWait);
        name=faker.name().name();
        phoneNumber=faker.phoneNumber().phoneNumber();
        country=faker.address().country();
        urlTwitter="https://"+faker.internet().url();
        urlGitHub="https://"+faker.internet().url();

    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.getSingUpButton().click();
        signupPage.fillSignUp(name, faker.internet().emailAddress(), "5555333", "5555333");
        //loginPage.fillLogIn(VALIDEMAIL, VALIDPASSWORD);
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getCloseButton()));
        signupPage.getCloseButton().click();
        driverWait.until(ExpectedConditions.urlContains(baseUrl+"/home"));
        profilePages.getMyProfile().click();
    }

    @Test
    public void editsProfile() {
        profilePages.fillProfile(name, phoneNumber, country, urlTwitter, urlGitHub);
        driverWait.until(ExpectedConditions.visibilityOf(profilePages.getMessage()));
        Assert.assertTrue(profilePages.getMessage().getText().contains("Profile saved successfuly"));
        Assert.assertEquals(profilePages.getName().getAttribute("value"), name);
        Assert.assertEquals(profilePages.getPhoneNumber().getAttribute("value"), phoneNumber);
        Assert.assertEquals(profilePages.getCity().getAttribute("value"), "Barranquilla");
        Assert.assertEquals(profilePages.getCountry().getAttribute("value"), country);
        Assert.assertEquals(profilePages.getTwitter().getAttribute("value"), urlTwitter);
        Assert.assertEquals(profilePages.getGitHub().getAttribute("value"), urlGitHub);
    }


}