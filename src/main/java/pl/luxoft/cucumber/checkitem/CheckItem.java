package pl.luxoft.cucumber.checkitem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.luxoft.cucumber.enums.CheckExecutionStatus;
import pl.luxoft.cucumber.enums.CheckItemState;

public class CheckItem {

    private String title;
    private int numOfExecutions;
    private CheckExecutionStatus status;
    private CheckItemState state;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public CheckItem(String title){
        this(title, 1);
    }

    public CheckItem(String title, int numOfExecutions) {
        this.title = title;
        this.numOfExecutions = numOfExecutions;
        this.status = CheckExecutionStatus.UNKNOWN;
        this.state = CheckItemState.ACTIVE;
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
        logger.warn("Check status can be changed only for IN_PROGRESS items!");
        if (this.getStatus() == CheckExecutionStatus.IN_PROGRESS){
            logger.info("Check status is " + requiredStatus.toString()
                    + " for item " + this.title);
            this.setStatus(requiredStatus);
        }
    }

    public void setState(CheckItemState state) {
        this.state = state;
    }

    public CheckItemState getState() {
        return state;
    }
}
