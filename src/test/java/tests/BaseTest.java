package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";

    protected final String VALIDEMAIL = "admin@admin.com";
    protected final String VALIDPASSWORD = "12345";
    protected Faker faker;
    protected HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("driver.chrome.driver", "F:\\IVANA KOMP\\chromedriver.exe");
        driver = new ChromeDriver();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        faker=new Faker();
        homePage=new HomePage(driver,driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void afterMethod() {
        try {
            homePage.getLogoutButton().click();
        } catch (Exception e) {

        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
