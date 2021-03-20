package by.paulouskin.todo.core.item;

import by.paulouskin.todo.abstraction.AbstractTodoItem;
import by.paulouskin.todo.core.info.CTodoInfo;
import by.paulouskin.todo.enums.TodoStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CTodoItem extends AbstractTodoItem<CTodoInfo> {


    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public CTodoItem(String title) {
        this.data = new CTodoInfo(title);
        creationDate = dateFormat.format(new Date());
        status = TodoStatus.PENDING;
    }

    public CTodoItem() {
        this.data = new CTodoInfo();
        creationDate = dateFormat.format(new Date());
        status = TodoStatus.PENDING;
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
