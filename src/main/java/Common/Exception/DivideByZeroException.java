package Common.Exception;

public class DivideByZeroException extends ArithmeticException {
    public DivideByZeroException() {
        super("0으로 나눗셈 불가");
    }
}
