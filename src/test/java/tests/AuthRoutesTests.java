package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class AuthRoutesTests extends BaseTest {
    private HomePage homePage;

    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver, driverWait);
    }


    @Test
    public void forbidsVisitsToTomeUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/home");
        Assert.assertTrue(homePage.isLogedOut(baseUrl));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
    }

    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/profile");
        Assert.assertTrue(homePage.isLogedOut(baseUrl));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
    }

    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/cities");
        Assert.assertTrue(homePage.isLogedOut(baseUrl));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
    }

    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseUrl + "/admin/users");
        Assert.assertTrue(homePage.isLogedOut(baseUrl));
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login");
    }

    @AfterMethod
    public void afterMethod() {
        try {
            homePage.getLogoutButton().click();
        } catch (Exception e) {

        }
    }
}
