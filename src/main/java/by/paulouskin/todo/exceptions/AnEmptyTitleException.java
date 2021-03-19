package by.paulouskin.todo.exceptions;

public class AnEmptyTitleException extends RuntimeException {
    public AnEmptyTitleException(String message) {
        super(message);
    }
}
