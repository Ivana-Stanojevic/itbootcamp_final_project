package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement logoutButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[4]")
    private WebElement singUpButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button/span")
    private WebElement languageButton;

    @FindBy(className = "btnES")
    private WebElement esLanguage;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement messageLanguage;

    @FindBy(className = "btnEN")
    private WebElement enLanguage;


    @FindBy(className = "btnFR")
    private WebElement frLanguage;


    public void selectLanguageEs() {
        languageButton.click();
        esLanguage.click();
        driverWait.until(ExpectedConditions.visibilityOf(messageLanguage));

    }

    public void selectLanguageEn() {
        languageButton.click();
        enLanguage.click();
        driverWait.until(ExpectedConditions.visibilityOf(messageLanguage));
    }

    public void selectLanguageFr() {
        languageButton.click();
        frLanguage.click();
        driverWait.until(ExpectedConditions.visibilityOf(messageLanguage));
    }

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void loginButtonClick() {
        loginButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isLogoutButtonVisible() {
        return logoutButton.isDisplayed();
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    public WebElement getSingUpButton() {
        return singUpButton;
    }

    public WebElement getMessageLanguage() {
        return messageLanguage;
    }

    public WebElement getEnLanguage() {
        return enLanguage;
    }

    public WebElement getFrLanguage() {
        return frLanguage;
    }

    public WebElement getEsLanguage() {
        return esLanguage;
    }

    public boolean isLogedOut(String url) {
        if (driver.getCurrentUrl().equals(url) || driver.getCurrentUrl().equals(url + "/login")) {
            return true;
        }
        return false;
    }
}
