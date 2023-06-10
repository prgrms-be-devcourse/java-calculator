package exception;

public class IllegalExpressionException extends RuntimeException {
    public IllegalExpressionException() {
    }

    public IllegalExpressionException(String message) {
        super(message);
    }

    public IllegalExpressionException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalExpressionException(Throwable cause) {
        super(cause);
    }
}
