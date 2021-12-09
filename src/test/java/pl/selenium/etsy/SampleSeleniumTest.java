package pl.selenium.etsy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleSeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void shouldOpenGooglePageAndSearchForSelenium() {
        //System.setProperty("webdriver.chrome.driver", "C:\\Dev\\chromedriver.exe");
        driver.get("http://www.google.com");
        WebElement acceptBtn = driver.findElement(By.id("L2AGLb"));
        acceptBtn.click();
        WebElement queryField = driver.findElement(By.name("q"));
        queryField.sendKeys("Selenium");
        queryField.sendKeys(Keys.ENTER);
        Assertions.assertTrue(driver.getTitle().toLowerCase().contains("selenium"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
