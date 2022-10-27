package calculator.exception;

public enum MenuException {

    MENU_FIND_NULL_EXCEPTION("존재하지 않는 기능 번호 입니다.");

    private final String message;

    MenuException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
