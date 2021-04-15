package pl.luxoft.cucumber.checkitem;

public class CheckItem {

    private String title;
    private int numOfExecutions;

    public CheckItem(String title){
        this.title = title;
        this.numOfExecutions = 1;
    }

    public CheckItem(String title, int numOfExecutions) {
        this.title = title;
        this.numOfExecutions = numOfExecutions;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isEmpty()) {
            return;
        }
        this.title = title;
    }

    public int getNumOfExecutions() {
        return numOfExecutions;
    }

    public void setNumOfExecutions(int numOfExecutions) {
        this.numOfExecutions = numOfExecutions;
    }
}
