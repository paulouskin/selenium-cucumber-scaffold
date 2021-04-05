package by.paulouskin.cucumber.glue.todo;

import by.paulouskin.todo.abstraction.AbstractTodoItem;
import by.paulouskin.todo.core.info.CTodoInfo;
import by.paulouskin.todo.core.item.CTodoItem;
import by.paulouskin.todo.enums.TodoStatus;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.time.Instant;

public class TodoItemSteps extends BaseSteps{

    private AbstractTodoItem todo;
    private String todoTitle;

    @Before
    public void setUp(Scenario scenario) {
        logger.info(String.format("You are running '%s' scenario", scenario.getName()));
    }

    @Given("a new todo item")
    public void a_new_todo_item() {
        todo = new CTodoItem();
    }

    @When("I set todo item title to {string}")
    public void i_set_todo_item_title_to(String string) {
        todo.setData(new CTodoInfo(string));
    }

    @When("I get todo item title")
    public void i_get_todo_item_title() {
        todoTitle = ((CTodoItem)todo).getTitle();
    }

    @Then("todo item title is {string}")
    public void todo_item_title_is(String string) {
        Assert.assertTrue(((CTodoItem)todo).getTitle().equalsIgnoreCase(string));
    }

    @Then("todo item has an empty title")
    public void todo_item_has_an_empty_title() {
        Assert.assertTrue(((CTodoItem)todo).getTitle().isEmpty());
    }

    @Then("todo item status is {string}")
    public void todo_item_status_is(String string) {
        TodoStatus expectedStatus = TodoStatus.valueOf(string.toUpperCase());
        Assert.assertTrue(expectedStatus == todo.getStatus());
    }

    @Then("todo item date is today's date")
    public void todo_item_date_is_today_s_date() {
        var dateFormatter = todo.getDateFormat();
        var today = Instant.now();
        String todayDate = dateFormatter.format(today);
        logger.info("Expected date is " + todayDate);
        Assert.assertTrue(todo.getCreationDate().equalsIgnoreCase(todayDate));

    }


    @After
    public void tearDown(Scenario scenario) {
        logger.info(String.format("Scenario '%s' run with status '%s' ",
                scenario.getName(), scenario.getStatus().toString()));
    }

}
