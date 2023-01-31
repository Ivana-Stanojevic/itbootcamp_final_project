package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/header/div/div[3]/a[3]/span")
    private WebElement loginButton;



    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void loginButtonClick() {
        loginButton.click();
    }
}
