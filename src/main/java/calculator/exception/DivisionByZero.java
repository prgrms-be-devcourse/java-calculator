package calculator.exception;

public class DivisionByZero extends RuntimeException {
    public DivisionByZero() {
        super();
    }

    public DivisionByZero(String message) {
        super(message);
    }

    public DivisionByZero(String message, Throwable cause) {
        super(message, cause);
    }

    public DivisionByZero(Throwable cause) {
        super(cause);
    }

    protected DivisionByZero(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
