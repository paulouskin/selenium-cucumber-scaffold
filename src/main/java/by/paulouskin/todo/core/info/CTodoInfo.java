package by.paulouskin.todo.core.info;

public class CTodoInfo {

    protected String title;

    public CTodoInfo(String title) {
        this.title = title;
    }

    public CTodoInfo() {
        this.title = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
