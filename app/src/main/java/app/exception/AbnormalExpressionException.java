package app.exception;

public class AbnormalExpressionException extends RuntimeException{
    public AbnormalExpressionException() {
        super("잘못된 연산식입니다.");
    }
}
