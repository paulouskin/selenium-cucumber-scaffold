package by.paulouskin.todo.core;

import by.paulouskin.todo.enums.TodoStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CTodoItem {

    private String title;

    public String getCreationDate() {
        return creationDate;
    }

    private String creationDate;
    private TodoStatus status;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public CTodoItem(String title) {
        this.title = title;
        creationDate = dateFormat.format(new Date());
        status = TodoStatus.PENDING;
    }

    public CTodoItem() {
        creationDate = dateFormat.format(new Date());
        status = TodoStatus.PENDING;
    }

    public String getTitle() {
        return title == null ? "" : title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TodoStatus getStatus() {
        return status;
    }

    public void setStatus(TodoStatus status) {
        this.status = status;
    }

    public void complete() {
        this.status = TodoStatus.COMPLETED;
    }

    public void toggle() {
        if (this.status == TodoStatus.PENDING || this.status == TodoStatus.COMPLETED) {
            this.status = TodoStatus.IN_PROGRESS;
        } else {
            this.status = TodoStatus.PENDING;
        }
    }
}
