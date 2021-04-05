package by.paulouskin.cucumber.glue.todo;

import by.paulouskin.todo.core.item.CTodoItem;
import by.paulouskin.todo.core.list.TodoList;
import by.paulouskin.todo.enums.TodoPriority;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.stream.Collectors;

public class TodoListSteps extends BaseSteps{

    private TodoList<CTodoItem> todoList;

    @Given("an empty todo list {string}")
    public void an_empty_todo_list(String string) {
        todoList = new TodoList<>(string);
    }

    @Given("following todo items:")
    public void following_todo_items(DataTable dataTable) {
        List<CTodoItem> items = convertDataTableToItems(dataTable);
        todoList.add(items);
    }

    private List<CTodoItem> convertDataTableToItems(DataTable dataTable){
        return dataTable.asLists()
                .stream()
                .skip(1)
                .map(fields -> new CTodoItem(fields.get(0), TodoPriority.valueOf(fields.get(1))))
                .collect(Collectors.toList());
    }
}
