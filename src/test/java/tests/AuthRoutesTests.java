package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest{


    @Test
    public void forbidsVisitsToTomeUrlIfNotAuthenticated() {
        driver.get(baseUrl+"/home");
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/login");
    }

    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        driver.get(baseUrl+"/profile");
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/login");
    }

    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        driver.get(baseUrl+"/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/login");
    }

    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        driver.get(baseUrl+"/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl+"/login");
    }



}
