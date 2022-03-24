package exception;

public class CalculatorException extends RuntimeException {

    CalculatorException() {
    }

    public CalculatorException(String msg) {
        super(msg);
    }

}
