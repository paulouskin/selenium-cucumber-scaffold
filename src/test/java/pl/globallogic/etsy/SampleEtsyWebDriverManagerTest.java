package pl.globallogic.etsy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleEtsyWebDriverManagerTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void shouldOpenGooglePageAndSearchForSelenium() {
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.findElement(By.id("L2AGLb")).click();
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        Assertions.assertTrue(driver.getTitle().toLowerCase().contains("selenium"));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
