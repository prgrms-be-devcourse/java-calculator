package calculator.exception;

public class NotSaveException extends RuntimeException{
    private static final String MSG = "DB 저장 실패";

    public NotSaveException() {
        super(MSG);
    }
}
