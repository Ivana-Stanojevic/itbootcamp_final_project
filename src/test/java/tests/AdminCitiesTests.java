package tests;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminCitiesPage;
import pages.LoginPage;

public class AdminCitiesTests extends BaseTest {
    private LoginPage loginPage;
    private AdminCitiesPage adminCitiesPage;
    private String myCity;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
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

    @Test(priority = 1)

    public void createNewCity() {
        adminCitiesPage.createNewCity(myCity);
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getMessage()));
        Assert.assertTrue(adminCitiesPage.getMessage().getText().contains("Saved successfully"));

    }

    @Test(priority = 2)
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

    @Test(priority = 3)
    public void searchCity() {
        adminCitiesPage.searchCity(myCity + " - edited");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals(adminCitiesPage.getCityNameTable().getText(), myCity + " - edited");

    }

    @Test(priority = 4)
    private void deleteCity() {
        adminCitiesPage.searchCity(myCity);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(adminCitiesPage.getCityNameTable().getText().contains(myCity));
        adminCitiesPage.deleteCity();
        driverWait.until(ExpectedConditions.visibilityOf(adminCitiesPage.getDeleteMessage()));
        Assert.assertTrue(adminCitiesPage.getDeleteMessage().getText().contains("Deleted successfully"));
    }

}
