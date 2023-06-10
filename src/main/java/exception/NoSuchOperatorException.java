package exception;

public class NoSuchOperatorException extends RuntimeException {
    public NoSuchOperatorException() {
    }

    public NoSuchOperatorException(String message) {
        super(message);
    }

    public NoSuchOperatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchOperatorException(Throwable cause) {
        super(cause);
    }
}
