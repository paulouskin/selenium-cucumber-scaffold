package by.paulouskin.todo.core.list;

import by.paulouskin.todo.abstraction.AbstractTodoItem;

import java.util.ArrayList;
import java.util.List;

public class TodoList<T extends AbstractTodoItem> {

    private ArrayList<T> list;
    private String title;

    public TodoList(String title) {
        list = new ArrayList<>();
        this.title = title;
    }

    public void add(List<T> items) {
        list.addAll(items);
    }
}
