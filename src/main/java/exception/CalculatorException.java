package exception;

public class CalculatorException extends RuntimeException{
    private final String message;

    public CalculatorException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
