package exception;

public class CalculatorException extends Exception{
    private final String message;

    public CalculatorException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
