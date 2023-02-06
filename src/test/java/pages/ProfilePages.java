package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfilePages extends BasePage {


    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "phone")
    private WebElement phoneNumber;

    @FindBy(name = "city")
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


    public void fillProfile(String name, String phoneNumber, String city, String country, String twitter, String gitHub) {
        this.name.click();
        this.name.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        this.name.sendKeys(Keys.DELETE);
        this.name.sendKeys(name);
        this.phoneNumber.click();
        this.phoneNumber.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        this.phoneNumber.sendKeys(Keys.DELETE);
        this.phoneNumber.sendKeys(phoneNumber);
        this.city.click();
        this.city.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        this.city.sendKeys(Keys.DELETE);
        this.city.sendKeys(city);
        this.city.sendKeys(Keys.ARROW_DOWN);
        this.city.sendKeys(Keys.ARROW_DOWN);
        this.city.sendKeys(Keys.ENTER);
        this.country.click();
        this.country.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        this.country.sendKeys(Keys.DELETE);
        this.country.sendKeys(country);
        this.twitter.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        this.twitter.sendKeys(Keys.DELETE);
        this.twitter.sendKeys(twitter);
        this.gitHub.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        this.gitHub.sendKeys(Keys.DELETE);
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
