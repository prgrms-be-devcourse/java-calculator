package caculator.exception;

public class CalculatorException extends Exception{
    String msg;

    public CalculatorException(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
