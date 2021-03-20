package by.paulouskin.cucumber.stepdefs.todo;

import by.paulouskin.todo.abstraction.AbstractTodoItem;
import by.paulouskin.todo.core.info.CTodoInfo;
import by.paulouskin.todo.core.item.CTodoItem;
import by.paulouskin.todo.enums.TodoStatus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TodoItemSteps extends BaseSteps{

    private AbstractTodoItem todo;
    private String todoTitle;

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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String today = dateFormat.format(new Date());
        logger.info("Expected date is " + today);
        Assert.assertTrue(todo.getCreationDate().equalsIgnoreCase(today));

    }

}
