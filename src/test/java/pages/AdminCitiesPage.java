package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AdminCitiesPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]")
    private WebElement adminButton;
    @FindBy(className = "btnAdminCities")
    private WebElement cities;


    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span")
    private WebElement newItem;

    @FindBy(id = "name")
    private WebElement cityName;

    @FindBy(className = "btnSave")
    private WebElement saveButton;


    @FindBy(id = "search")
    private WebElement searchField;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement message;
    @FindAll({@FindBy(id = "edit")})
    private List<WebElement> cityListEdit;

    @FindBy(id = "edit")
    private WebElement editButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement cityNameTable;

    @FindBy(className = "mdi-delete")
    private WebElement deleteInTable;
    @FindBy(className = "text--lighten3")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement deleteMessage;

    public void createNewCity(String itemName) {
        newItem.click();
        this.cityName.sendKeys(itemName);
        saveButton.click();
    }

    public void openAdminCitiesPage() {

        adminButton.click();
        cities.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void searchCity(String city) {
        searchField.sendKeys(city);
    }

    public void editCity(String city) {
        editButton.click();
        driverWait.until(ExpectedConditions.visibilityOf(cityName));

        // this.cityName.clear();
        cityName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        cityName.sendKeys(Keys.DELETE);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        cityName.sendKeys(city + " - edited");
        saveButton.click();
    }


    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {

        super(driver, driverWait);
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getCityName() {
        return cityName;
    }

    public WebElement getCityNameTable() {
        return cityNameTable;
    }

    public WebElement getDeleteMessage() {
        return deleteMessage;
    }

    public void deleteCity() {
        deleteInTable.click();
        driverWait.until(ExpectedConditions.visibilityOf(deleteButton));
        deleteButton.click();

    }
}
