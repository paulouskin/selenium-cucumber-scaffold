package pl.qaupskilling.cucumber.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.qaupskilling.etsy.pageobject.PrivacyPolicyModalPO;

import java.time.Duration;

public class EtsySteps {

    private static final String PRIVACY_POLICY_ACCEPT_BTN = "//button[@data-gdpr-single-choice-accept='true']";
    private static final String SEARCH_QUERY_TEXT_FLD = "//input[@id='global-enhancements-search-query']";
    private static final String ACCEPT_POLICY_ALERT = "//div[contains(@class,wt-alert)]";
    private static final String PRIVACY_POLICY_MODAL_CONTENT = "//div[@class='nova-widget-content-redux']/p";
    private static final String UPDATE_SETTINGS_BUTTON = "//button[@data-gdpr-open-full-settings]";
    private static final String UPDATE_SETTINGS_TITLE = "//h3[@id='gdpr-full-settings-overlay-title']";

    private WebDriver driver;
    private String policyModalText;
    private WebElement acceptPolicyBtn;
    private PrivacyPolicyModalPO privacyPolicyPage;

    private Logger logger = LoggerFactory.getLogger(EtsySteps.class);

    @Before("@ui")
    public void scenarioSetUp(){
        logger.info("Scenario set up");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Given("{string} is on the main page")
    public void is_on_the_main_page(String persona) {
        System.out.println("Current thread: " + Thread.currentThread().getId());
        driver.get("https://www.etsy.com");
        privacyPolicyPage = new PrivacyPolicyModalPO(driver);
    }

    @When("{string} accepts privacy policy with default settings")
    public void accepts_privacy_policy_with_default_settings(String persona) {
        /*acceptPolicyBtn = driver.findElement(By.xpath(PRIVACY_POLICY_ACCEPT_BTN));
        acceptPolicyBtn.click();*/
        privacyPolicyPage.acceptPolicy();
    }

    @Then("{string} can proceed with shopping")
    public void can_proceed_with_shopping(String persona) {
        /*boolean isPolicyModalInvisible = new WebDriverWait(driver, 10).until(
                ExpectedConditions.invisibilityOf(acceptPolicyBtn)
        );
        boolean isPolicyModalInvisible = new FluentWait<>(driver).withTimeout(Duration.of(10,ChronoUnit.SECONDS))
                .pollingEvery(Duration.of(1, ChronoUnit.SECONDS)).until(
                        ExpectedConditions.invisibilityOf(acceptPolicyBtn)
                );*/
        //Assertions.assertTrue(isPolicyModalInvisible);
        Assertions.assertTrue(privacyPolicyPage.isModalInvisible());
    }

    @Given("the privacy policy modal text:")
    public void thePrivacyPolicyModalText(String expectedText) {
        policyModalText = expectedText;
    }

    @Then("the privacy modal contains expected text")
    public void thePrivacyModalContainsExpectedText() {
        String actualText = privacyPolicyPage.getShortPolicyDescription();
                //driver.findElement(By.xpath(PRIVACY_POLICY_MODAL_CONTENT)).getText();
        Assertions.assertTrue(policyModalText.contentEquals(actualText));
    }


    @Then("the link to {string} is available")
    public void privacyPolicyLinkIsAvailable(String linkText) {
        WebElement privacyPolicyLink = privacyPolicyPage.getPolicyLink(linkText.split(" ")[0]);
                //driver.findElement(By.linkText(linkText));
        Assertions.assertTrue(privacyPolicyLink.isDisplayed());
    }

    @When("{string} search for {string}")
    public void search_for(String persona, String query) {
        WebElement searchQueryField = driver.findElement(By.xpath(SEARCH_QUERY_TEXT_FLD));
        searchQueryField.sendKeys(query);
        searchQueryField.sendKeys(Keys.ENTER);
    }

    @Then("search result page is visible")
    public void search_result_page_is_visible() {
        driver.quit();
    }

    @And("privacy policy modal is visible")
    public void privacyPolicyModalIsVisible() {
        //WebElement modalText = driver.findElement(By.xpath(PRIVACY_POLICY_MODAL_CONTENT));
        Assertions.assertTrue(privacyPolicyPage.getPrivacyPolicyLink().isDisplayed());
    }

    @When("{string} go to full privacy policy settings")
    public void goToFullPrivacyPolicySettings(String persona) {
        WebElement updatePolicyBtn = driver.findElement(By.xpath(UPDATE_SETTINGS_BUTTON));
        updatePolicyBtn.click();
    }

    @Then("update policy settings modal is visible")
    public void updatePolicySettingsModalIsVisible() {
        WebElement updateSettingsTitle =//driver.findElement(By.xpath(UPDATE_SETTINGS_TITLE));
                new WebDriverWait(driver, Duration.ofSeconds(5)).until(
                        ExpectedConditions.visibilityOfElementLocated(By.xpath(UPDATE_SETTINGS_TITLE))
                );
        Assertions.assertTrue(updateSettingsTitle.isDisplayed());
    }

    @After("@ui")
    public void scenarioCleanUp(){
        driver.quit();
    }
}
