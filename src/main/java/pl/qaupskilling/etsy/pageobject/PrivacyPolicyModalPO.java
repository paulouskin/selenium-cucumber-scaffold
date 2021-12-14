package pl.qaupskilling.etsy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrivacyPolicyModalPO extends BasePageObject{

    //@FindBy(xpath = "//button[@data-gdpr-single-choice-accept='true']")
    @FindBy(how = How.XPATH, using = "//button[@data-gdpr-single-choice-accept='true']")
    private WebElement acceptPolicyBtn;

    @FindBy(xpath = "//button[@data-gdpr-open-full-settings]")
    //@FindBy(how = How.XPATH, using = "//button[@data-gdpr-open-full-settings]")
    private WebElement updatePolicySettingsBtn;

    @FindBy(xpath = "//div[@class='nova-widget-content-redux']/p")
    private WebElement policyText;

    @FindBy(linkText = "Privacy Policy")
    private WebElement privacyPolicyLink;

    @FindBy(linkText = "Cookie Policy")
    private WebElement cookiePolicyLink;

    public PrivacyPolicyModalPO(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void acceptPolicy() {
        acceptPolicyBtn.click();
    }

    public void updateSettings() {
        updatePolicySettingsBtn.click();
    }

    public String getShortPolicyDescription() {
        return policyText.getText();
    }

    public WebElement getPolicyLink(String policyType) {
        WebElement link;
        switch (policyType){
            case "Privacy": link =  privacyPolicyLink;break;
            case "Cookie" : link =  cookiePolicyLink;break;
            default: throw new IllegalArgumentException("Wrong policy type");
        }
        return link;
    }

    public WebElement getPrivacyPolicyLink() {
        return privacyPolicyLink;
    }

    public WebElement getCookiePolicyLink() {
        return cookiePolicyLink;
    }

    public boolean isModalInvisible() {
        return new WebDriverWait(driver, DEFAULT_WAIT_TIME).until(
                ExpectedConditions.invisibilityOf(acceptPolicyBtn)
        );
    }

}
