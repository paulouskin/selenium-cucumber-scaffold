package pl.qaupskilling.etsy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

    protected final int DEFAULT_WAIT_TIME = 10;

    protected WebDriver driver;

    public BasePageObject(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement findElement(By locator) {
        return new WebDriverWait(driver, DEFAULT_WAIT_TIME).until(
                driver -> driver.findElement(locator)
        );
    }

    protected boolean isElementInvisible(WebElement element) {
        return new WebDriverWait(driver, DEFAULT_WAIT_TIME).until(
                ExpectedConditions.invisibilityOf(element)
        );
    }
}
