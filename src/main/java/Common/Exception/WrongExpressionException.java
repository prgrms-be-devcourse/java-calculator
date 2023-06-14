package Common.Exception;

public class WrongExpressionException extends RuntimeException {

    public WrongExpressionException() {
        super("잘못된 식 입력");
    }
}
