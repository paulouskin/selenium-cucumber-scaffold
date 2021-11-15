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
import pl.qaupskilling.cucumber.pageobjects.EtsyPagePO;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class EtsySteps {

    public static final String POPULARS_AREA = "//ul[contains(@class,'wt-list-unstyled')]";
    public static final String SIGNIN_BUTTON = "//button[contains(@class,'select-signin')]";
    public static final String SHOP_SELECTIONS = "//a[contains(@class,'wt-card__link')]";
    public static final String SUBSCRIBE_AREA = "//input[@id='email-list-signup-email-input']";
    public static final String SEARCH_QUERY = "//input[@name='search_query']";

    Logger logger = LoggerFactory.getLogger(EtsySteps.class);

    private WebDriver driver;

    private EtsyPagePO landingPage;

    @Before("@ui")
    public void scenarioSetUp() {
        WebDriverManager.chromedriver().setup();
        logger.info("Starting web driver instance...");
        driver = new ChromeDriver();
        landingPage = new EtsyPagePO(driver);
    }

    @After("@ui")
    public void scenarioTearDown() {
        logger.info("Closing web driver instance...");
        driver.quit();
    }

    @Given("{string} on the shop landing page")
    public void on_the_shop_landing_page(String string){
        landingPage.goTo();
    }

    @When("(she|he) accepts privacy policy with default settings")
    public void he_accepts_privacy_policy_with_default_settings() {
        landingPage.acceptPrivacyPolicy();
        landingPage.waitForPolicyModalToDisappear();

    }

    @Then("{string} can proceed with shopping")
    public void can_proceed_with_shopping(String string) {
        boolean policyModalNotVisible = landingPage.waitForPolicyModalToDisappear();
        Assertions.assertTrue(policyModalNotVisible);
    }


    @And("he search for {string}")
    public void heSearchFor(String item) {
        WebElement searchField = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(SEARCH_QUERY)));
        searchField.sendKeys(item);
        searchField.sendKeys(Keys.ENTER);
    }

    @Then("search results contains item with title {string}")
    public void searchResultsContainsItemWithTitle(String query) {
        List<WebElement> searchResultsTitles = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                                By.xpath("//h3[contains(@class,'v2-listing-card__title')]")));
        List<String> words = List.of(query.split(" "));
        List<List<String>> splitedTitles = searchResultsTitles
                .stream()
                .map(el -> List.of(el.getText().toLowerCase().split(" ")))
                .collect(Collectors.toList());
        boolean pass = splitedTitles.stream()
                .anyMatch(item -> item.containsAll(words));
        assertThat(pass, equalTo(true));
    }

    @Then("populars is visible")
    public void popularsIsVisible() {
        WebElement populars = new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(POPULARS_AREA))
        );
        Assertions.assertTrue(populars.isDisplayed());
    }

    @Then("Sign in button is visible")
    public void signInButtonIsVisible() {
        WebElement signInBtn = new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(SIGNIN_BUTTON))
        );
        Assertions.assertTrue(signInBtn.isDisplayed());
    }

    @And("subscribe area is visible")
    public void subscribeAreaIsVisible() {
        WebElement populars = new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(SUBSCRIBE_AREA))
        );
        Assertions.assertTrue(populars.isDisplayed());

    }

    @Then("shop selections is visible")
    public void shopSelectionsIsVisible() {
        WebElement populars = new WebDriverWait(driver, 5).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(SHOP_SELECTIONS))
        );
        Assertions.assertTrue(populars.isDisplayed());
    }
}
