package exception;

public class CalculatorException extends Exception{
    private final String message;

    public CalculatorException(final String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
