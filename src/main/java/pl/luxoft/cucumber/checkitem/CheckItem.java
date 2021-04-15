package pl.luxoft.cucumber.checkitem;

import pl.luxoft.cucumber.enums.CheckExecutionStatus;

public class CheckItem {

    private String title;
    private int numOfExecutions;
    private CheckExecutionStatus status;

    public CheckItem(String title){
        this(title, 1);
    }

    public CheckItem(String title, int numOfExecutions) {
        this.title = title;
        this.numOfExecutions = numOfExecutions;
        this.status = CheckExecutionStatus.UNKNOWN;
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

    public CheckExecutionStatus getStatus() {
        return status;
    }

    private void setStatus(CheckExecutionStatus status) {
        this.status = status;
    }

    public void startProgress() {
        this.status = CheckExecutionStatus.IN_PROGRESS;
    }

    public void markAs(CheckExecutionStatus requiredStatus) {
        if (this.getStatus() == CheckExecutionStatus.IN_PROGRESS){
            this.setStatus(requiredStatus);
        }
    }
}
