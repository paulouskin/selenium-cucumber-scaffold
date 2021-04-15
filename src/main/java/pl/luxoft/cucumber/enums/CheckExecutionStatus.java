package pl.luxoft.cucumber.enums;

public enum CheckExecutionStatus {
    PASSED("PASSED"),
    FAILED("FAILED"),
    PENDING("PENDING"),
    IN_PROGRESS("IN_PROGRESS"),
    UNKNOWN("UNKNOWN");
    private String description;

    CheckExecutionStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
