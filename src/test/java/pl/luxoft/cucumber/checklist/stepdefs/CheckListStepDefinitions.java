package pl.luxoft.cucumber.checklist.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pl.luxoft.cucumber.checkitem.CheckItem;
import pl.luxoft.cucumber.checklist.CheckList;

public class CheckListStepDefinitions {

    private CheckList checkList;

    @Given("a check list named {string}")
    public void a_check_list_named(String title) {
        checkList = new CheckList(title);
    }
    @When("I add a {string} check list item")
    public void i_add_a_check_list_item(String checkItemTitle) {
        checkList.add(new CheckItem(checkItemTitle));
    }
    @Then("check list size is equal to {int}")
    public void check_list_size_is_equal_to(int expectedSize) {
        Assert.assertTrue("Expected check list size not equal to actual one",
                expectedSize == checkList.size());
    }

    @When("I delete {string} check list item")
    public void iDeleteCheckListItem(String checkItemTitle) {
        checkList.printAllItems();
        checkList.delete(checkItemTitle);
    }
}
