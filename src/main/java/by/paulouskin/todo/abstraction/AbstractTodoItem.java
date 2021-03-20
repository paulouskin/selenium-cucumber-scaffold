package by.paulouskin.todo.abstraction;

import by.paulouskin.todo.enums.TodoStatus;

import java.text.SimpleDateFormat;

public abstract class AbstractTodoItem<T> {

    protected T data;
    protected String creationDate;
    protected TodoStatus status;
    protected SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public AbstractTodoItem() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public abstract void toggle();
    public abstract void complete();
}
