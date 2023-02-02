package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminCitiesTests extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;
    private AdminCitiesPage adminCitiesPage;


    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);

    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        homePage.loginButtonClick();
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getEmail()));
        loginPage.fillLogIn(VALIDEMAIL, VALIDPASSWORD);
        driverWait.until(ExpectedConditions.urlContains("/home"));
        adminCitiesPage.openAdminCitiesPage();
    }

    @Test
    public void VisitsTheAdminCitiesPageAndListCities() {
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/admin/cities");
        Assert.assertTrue(homePage.isLogoutButtonVisible());
    }

    @Test
    public void createNewCity() {
        adminCitiesPage.createNewCity(faker.address().cityName());
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getMessage()));
        Assert.assertEquals(adminCitiesPage.getMessage().getText().substring(0, 18), "Saved successfully");

    }





    @AfterMethod
    public void afterrMethod() {
        if (driver.getCurrentUrl() != baseUrl) {
            homePage.getLogoutButton().click();
        }
    }
}
