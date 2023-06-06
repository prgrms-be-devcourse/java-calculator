package exception;

public class NotEquationFormatException extends RuntimeException{
    private static final String MSG = "계산식 입력 형식이 아닙니다.";

    public NotEquationFormatException() {
        super(MSG);
    }

    public NotEquationFormatException(String msg) {
        super(msg);
    }
}
