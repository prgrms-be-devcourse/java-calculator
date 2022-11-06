package engine.exception;

public class NotValidInputException extends RuntimeException {
    public NotValidInputException() {
        super();
    }

    public NotValidInputException(String message) {
        super(message);
    }

    public NotValidInputException(String message, Throwable cause) {
        super(message, cause);
    }
}
