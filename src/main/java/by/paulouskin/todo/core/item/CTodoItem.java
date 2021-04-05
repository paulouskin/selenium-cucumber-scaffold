package by.paulouskin.todo.core.item;

import by.paulouskin.todo.abstraction.AbstractTodoItem;
import by.paulouskin.todo.core.info.CTodoInfo;
import by.paulouskin.todo.enums.TodoPriority;
import by.paulouskin.todo.enums.TodoStatus;

public class CTodoItem extends AbstractTodoItem<CTodoInfo> {

    private TodoPriority priority;

    public CTodoItem(String title) {
        this.data = new CTodoInfo(title);
        status = TodoStatus.PENDING;
        priority = TodoPriority.MEDIUM;
    }

    public CTodoItem(String title, TodoPriority priority) {
        this.data = new CTodoInfo(title);
        status = TodoStatus.PENDING;
        this.priority = priority;
    }

    public CTodoItem() {
        this("");
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

    public String getTitle() {
        return this.data.getTitle();
    }

    public void setTitle(String title) {
        this.data.setTitle(title);
    }

    public TodoPriority getPriority() {
        return priority;
    }

    public void setPriority(TodoPriority priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "CTodoItem{" +
                "creationDate=" + creationDate +
                ", status=" + status +
                ", dateFormat=" + dateFormat +
                ", priority=" + priority +
                '}';
    }
}
