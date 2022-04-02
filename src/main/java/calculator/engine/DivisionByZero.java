package calculator.engine;

public class DevidedByZero extends RuntimeException {
    public DevidedByZero() {
        super();
    }

    public DevidedByZero(String message) {
        super(message);
    }

    public DevidedByZero(String message, Throwable cause) {
        super(message, cause);
    }

    public DevidedByZero(Throwable cause) {
        super(cause);
    }

    protected DevidedByZero(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
