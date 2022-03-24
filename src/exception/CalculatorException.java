package exception;

public class CalculatorException extends RuntimeException {

    public CalculatorException() {
    }

    public CalculatorException(String msg) {
        super(msg);
    }

}
