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
    public void
}
