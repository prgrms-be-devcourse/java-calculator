package exception;

public class ZeroDivisionException extends RuntimeException {
    private static final String MESSAGE = "0으로는 나눌 수 없습니다.";
    public ZeroDivisionException() {
        super(MESSAGE);
    }
}
