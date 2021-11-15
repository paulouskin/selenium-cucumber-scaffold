package pl.qaupskilling.cucumber.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EtsyPagePO {

    private final WebDriver driver;

    public static final String MAIN_PAGE_ADDRESS = "https://www.etsy.com";

    public static final String GDPR_SINGLE_CHOICE_OVERLAY = "gdpr-single-choice-overlay";
    public static final String ACCEPT_POLICY_BUTTON = "[class='wt-btn wt-btn--filled wt-mb-xs-0']";

    private WebElement policyWindow;

    public EtsyPagePO(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get(MAIN_PAGE_ADDRESS);
    }

    public void acceptPrivacyPolicy() {
        policyWindow = driver.findElement(By.id(GDPR_SINGLE_CHOICE_OVERLAY));
        WebElement acceptBtn = driver.findElement(By.cssSelector(ACCEPT_POLICY_BUTTON));
        acceptBtn.click();
    }

    public boolean waitForPolicyModalToDisappear() {
       return new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(policyWindow));
    }
}
