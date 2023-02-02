package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    private WebElement itemName;

    @FindBy(className = "btnSave")
    private WebElement saveButton;


    @FindBy(id = "search")
    private WebElement search;
    @FindBy(xpath = "//*[@id=\"app\"]/div[2]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement message;
    @FindAll({@FindBy(id = "edit")})
    private List<WebElement> cityListEdit;

    public void createNewCity(String itemName) {
        newItem.click();
        this.itemName.sendKeys(itemName);
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


    public AdminCitiesPage(WebDriver driver, WebDriverWait driverWait) {

        super(driver, driverWait);
    }

    public WebElement getMessage() {
        return message;
    }
}
