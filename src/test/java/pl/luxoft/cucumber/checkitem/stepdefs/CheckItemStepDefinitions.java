package pl.luxoft.cucumber.checkitem.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import pl.luxoft.cucumber.checkitem.CheckItem;
import pl.luxoft.cucumber.enums.CheckExecutionStatus;

import java.util.List;
import java.util.Map;


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

    @DataTableType
    public CheckItem fromMap(Map<String, String> entry){
        return new CheckItem(entry.get("title"), Integer.parseInt(entry.get("numOfExecutions")));
    }

    @Given("a check item(s?) with a following properties from data tables:")
    public void a_check_item_with_a_following_properties(DataTable dataTable) {
        List<Map<String, String>> itemsMap = dataTable.asMaps(String.class, String.class);
        Map<String, String> itemAsMap = itemsMap.get(0);
        item = new CheckItem(itemAsMap.get("title"), Integer.parseInt(itemAsMap.get("numOfExecutions")));
        System.out.println(item.getTitle());
    }


    @Given("a check item(s?) with following properties:")
    public void aCheckItemWithFollowingProperties(List<CheckItem> items) {
        item = items.get(0);
    }

    @When("I start working on the item check")
    public void iStartWorkingOnTheItemCheck() {
        item.startProgress();
    }

    @Then("check execution status is {string}")
    public void checkExecutionStatusIs(String executionStatus) {
        String actualExecutionStatus = item.getStatus().toString();
        Assert.assertTrue("Actual check execution status not equal to expected one",
                executionStatus.equalsIgnoreCase(actualExecutionStatus));
    }

    @When("mark check item as {string}")
    public void markCheckItemAs(String executionStatus) {
        CheckExecutionStatus requiredStatus = CheckExecutionStatus.valueOf(executionStatus.toUpperCase());
        item.markAs(requiredStatus);
    }

    @When("I archive check item")
    public void iArchiveCheckItem() {
        //Homework
    }

    @Then("check item have {string} state")
    public void checkItemHaveState(String expectedState) {
        //Homework
    }
}
