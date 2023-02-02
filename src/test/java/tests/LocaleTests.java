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
        homePage.selectLanguangeEs();
        Assert.assertEquals(homePage.getEsLanguage().getText(), "ES");
        Assert.assertEquals(homePage.getMessageLanguage().getText(),"Página de aterrizaje");

    }

    @Test
    public void setLocaleToEN() {
        homePage.selectLanguangeEn();
        Assert.assertEquals(homePage.getEnLanguage().getText(), "EN");
        Assert.assertEquals(homePage.getMessageLanguage().getText(),"Landing");
    }

    @Test
    public void setLocaleToFR() {
        homePage.selectLanguangeFr();
        Assert.assertEquals(homePage.getFrLanguage().getText(), "FR");
        Assert.assertEquals(homePage.getMessageLanguage().getText(),"Page d'atterrissage");
    }


}
