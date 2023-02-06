package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LocaleTests extends BaseTest {

    @Test
    public void setLocaleToES() {
        homePage.selectLanguageEs();
        Assert.assertEquals(homePage.getEsLanguage().getText(), "ES");
        Assert.assertEquals(homePage.getMessageLanguage().getText(), "Página de aterrizaje");
    }

    @Test
    public void setLocaleToEN() {
        homePage.selectLanguageEn();
        Assert.assertEquals(homePage.getEnLanguage().getText(), "EN");
        Assert.assertEquals(homePage.getMessageLanguage().getText(), "Landing");
    }

    @Test
    public void setLocaleToFR() {
        homePage.selectLanguageFr();
        Assert.assertEquals(homePage.getFrLanguage().getText(), "FR");
        Assert.assertEquals(homePage.getMessageLanguage().getText(), "Page d'atterrissage");
    }

}
