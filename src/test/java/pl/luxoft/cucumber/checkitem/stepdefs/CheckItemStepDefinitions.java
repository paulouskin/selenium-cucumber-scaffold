package pl.luxoft.cucumber.checkitem.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pl.luxoft.cucumber.checkitem.CheckItem;


public class CheckItemStepDefinitions {

    private CheckItem item;

    @Given("I have an access to application")
    public void i_have_an_access_to_application() {
        System.out.println("I am logged in...");
    }

    @Given("a check item with {string} title")
    public void aCheckItemWithTitle(String title) {
        item = new CheckItem(title);
    }

    @When("I create a check with a title {string}")
    public void i_create_a_check_with_a_title(String title) {
        item = new CheckItem(title);
    }
    @Then("check has a title {string}")
    public void check_has_a_title(String expectedTitle) {
        String actualTitle = item.getTitle();
        Assert.assertTrue(expectedTitle.equalsIgnoreCase(actualTitle));
    }

    @When("I replace check item title to {string}")
    public void iReplaceCheckItemTitleTo(String newTitle) {
        item.setTitle(newTitle);
    }

    @When("I specify that check need to be executed {int} times")
    public void iSpecifyThatCheckNeedToBeExecutedTimes(int numOfExecution) {
        item.setNumOfExecutions(numOfExecution);
    }

    @Then("check number of executions is equal to {int}")
    public void checkNumberOfExecutionsIsEqualTo(int numOfExecution) {
        int actualNumber = item.getNumOfExecutions();
        Assert.assertTrue("Expected number of executions not equal to actual one",
                numOfExecution == actualNumber);
    }
}
