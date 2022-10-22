package calculator.exception;

public enum NotationException {

    NOTATION_POSTFIX_NULL_EXCEPTION("후위 표기법 연산 중 오류가 발생하였습니다.");

    public final String message;

    NotationException(String message) {
        this.message = message;
    }
}
