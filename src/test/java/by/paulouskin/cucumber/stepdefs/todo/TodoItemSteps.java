package by.paulouskin.cucumber.stepdefs.todo;

import by.paulouskin.todo.core.CTodoItem;
import by.paulouskin.todo.enums.TodoStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItemSteps extends BaseSteps{

    private CTodoItem todo;
    private String todoTitle;

    @Given("a new todo item")
    public void a_new_todo_item() {
        todo = new CTodoItem();
    }

    @When("I set todo item title to {string}")
    public void i_set_todo_item_title_to(String string) {
        todo.setTitle(string);
    }

    @When("I get todo item title")
    public void i_get_todo_item_title() {
        todoTitle = todo.getTitle();
    }

    @Then("todo item title is {string}")
    public void todo_item_title_is(String string) {
        Assert.assertTrue(todo.getTitle().equalsIgnoreCase(string));
    }

    @Then("an empty string have been returned")
    public void an_empty_string_have_been_returned() {
        Assert.assertTrue(todo.getTitle().isEmpty());
    }

    @Then("todo item status is {string}")
    public void todo_item_status_is(String string) {
        TodoStatus expectedStatus = TodoStatus.valueOf(string.toUpperCase());
        Assert.assertTrue(expectedStatus == todo.getStatus());
    }

    @Then("todo item date is today's date")
    public void todo_item_date_is_today_s_date() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String today = dateFormat.format(new Date());
        logger.info("Expected date is " + today);
        Assert.assertTrue(todo.getCreationDate().equalsIgnoreCase(today));

    }

}
