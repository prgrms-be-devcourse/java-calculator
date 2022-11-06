package app.exception;

public class SelectInputValidateException extends RuntimeException {
    public SelectInputValidateException() {
        super("잘못된 입력값입니다.");
    }
}
