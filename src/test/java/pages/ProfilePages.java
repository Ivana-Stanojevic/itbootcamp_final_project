package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.util.List;

public class ProfilePages extends BasePage {


    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "phone")
    private WebElement phoneNumber;

@FindBy(name= "city")
    private WebElement city;

    @FindBy(id = "country")
    private WebElement country;

    @FindBy(id = "urlTwitter")
    private WebElement twitter;
    @FindBy(id = "urlGitHub")
    private WebElement gitHub;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement message;

    @FindBy(className = "btnProfile")
    private WebElement myProfile;

    public ProfilePages(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }



    public void fillProfile(String name, String phoneNumber, String country, String twitter, String gitHub) {
        this.name.clear();
        this.name.sendKeys(name);
        this.phoneNumber.clear();
        this.phoneNumber.sendKeys(phoneNumber);
        this.city.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        this.city.sendKeys(Keys.DELETE);
        this.city.sendKeys(Keys.ARROW_DOWN);
        this.city.sendKeys(Keys.ARROW_DOWN);
        this.city.sendKeys(Keys.ENTER);

        this.country.clear();
        this.country.sendKeys(country);
        this.twitter.clear();
        this.twitter.sendKeys(twitter);
        this.gitHub.clear();
        this.gitHub.sendKeys(gitHub);
        saveButton.click();
    }

    public WebElement getMyProfile() {
        return myProfile;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }



    public WebElement getCountry() {
        return country;
    }

    public WebElement getTwitter() {
        return twitter;
    }

    public WebElement getGitHub() {
        return gitHub;
    }

    public WebElement getCity() {
        return city;
    }
}
