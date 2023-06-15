package Common.Exception;

public class WrongValueException extends RuntimeException {
    public WrongValueException() {
        super("잘못된 값 입력");
    }
}
