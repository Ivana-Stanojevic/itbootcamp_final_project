package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class LocaleTests extends BaseTest{
    private HomePage homePage;


    @BeforeClass
    @Override
    public void beforeClass() {
        super.beforeClass();
        homePage=new HomePage(driver, driverWait);
    }

    @Test
    public void setLocaleToES() {

        homePage.selectLanguange();
        Assert.assertEquals(homePage.getMessageLanguage().getText(),"Página de aterrizaje");

    }
}
