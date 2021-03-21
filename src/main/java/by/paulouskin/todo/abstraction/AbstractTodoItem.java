package by.paulouskin.todo.abstraction;

import by.paulouskin.todo.enums.TodoStatus;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public abstract class AbstractTodoItem<T> {

    protected T data;
    protected final Instant creationDate;
    protected TodoStatus status;
    private String datePattern = "yyyy-MM-dd HH:mm";
    protected DateTimeFormatter dateFormat = DateTimeFormatter
            .ofPattern(datePattern).withZone(ZoneId.systemDefault());

    public AbstractTodoItem() {
        creationDate = Instant.now();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCreationDate() {
        return dateFormat.format(creationDate);
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

    public DateTimeFormatter getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateTimeFormatter dateFormat) {
        this.dateFormat = dateFormat;
    }

    protected abstract void toggle();
    protected abstract void complete();
}
