package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class ProfileTests extends BaseTest {
    private LoginPage loginPage;
    private ProfilePages profilePages;
    private String name;
    private String phoneNumber;
    private String country;
    private String city;
    private String urlTwitter;
    private String urlGitHub;
    private AdminCitiesPage adminCitiesPage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
        profilePages = new ProfilePages(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
        name = faker.name().name();
        phoneNumber = faker.phoneNumber().phoneNumber();
        city = faker.address().city();
        country = faker.address().country();
        urlTwitter = "https://" + faker.internet().url();
        urlGitHub = "https://" + faker.internet().url();

    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.loginButtonClick();
        loginPage.fillLogIn(VALIDEMAIL, VALIDPASSWORD);
        driverWait.until(ExpectedConditions.urlContains(baseUrl + "/home"));
        adminCitiesPage.openAdminCitiesPage();
        adminCitiesPage.createNewCity(city);
        profilePages.getMyProfile().click();
    }
    @Test
    public void editsProfile() {
        profilePages.fillProfile(name, phoneNumber, city, country, urlTwitter, urlGitHub);
        driverWait.until(ExpectedConditions.visibilityOf(profilePages.getMessage()));
        Assert.assertTrue(profilePages.getMessage().getText().contains("Profile saved successfuly"));
        Assert.assertEquals(profilePages.getName().getAttribute("value"), name);
        Assert.assertEquals(profilePages.getPhoneNumber().getAttribute("value"), phoneNumber);
        Assert.assertEquals(profilePages.getCity().getAttribute("value"), city);
        Assert.assertEquals(profilePages.getCountry().getAttribute("value"), country);
        Assert.assertEquals(profilePages.getTwitter().getAttribute("value"), urlTwitter);
        Assert.assertEquals(profilePages.getGitHub().getAttribute("value"), urlGitHub);
    }

}