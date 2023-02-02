package tests;

import javafx.scene.layout.Priority;
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
    private String myCity;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        adminCitiesPage = new AdminCitiesPage(driver, driverWait);
        myCity = faker.address().cityName();
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

    @Test(priority=1)

    public void createNewCity() {
        adminCitiesPage.createNewCity(myCity);
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getMessage()));
        Assert.assertTrue(adminCitiesPage.getMessage().getText().contains("Saved successfully"));

    }

    @Test(priority=2)
    public void editCity() {
        adminCitiesPage.searchCity(myCity);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        adminCitiesPage.editCity(myCity);
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getMessage()));
        Assert.assertTrue(adminCitiesPage.getMessage().getText().contains("Saved successfully"));
    }


    @AfterMethod
    public void afterrMethod() {
        if (driver.getCurrentUrl() != baseUrl) {
            homePage.getLogoutButton().click();
        }
    }
}
