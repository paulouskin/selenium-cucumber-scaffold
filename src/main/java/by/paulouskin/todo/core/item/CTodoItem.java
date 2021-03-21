package by.paulouskin.todo.core.item;

import by.paulouskin.todo.abstraction.AbstractTodoItem;
import by.paulouskin.todo.core.info.CTodoInfo;
import by.paulouskin.todo.enums.TodoStatus;

public class CTodoItem extends AbstractTodoItem<CTodoInfo> {

    public CTodoItem(String title) {
        this.data = new CTodoInfo(title);
        status = TodoStatus.PENDING;
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

}
