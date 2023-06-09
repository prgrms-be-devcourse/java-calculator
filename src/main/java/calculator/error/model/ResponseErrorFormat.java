package calculator.error.model;

public enum ResponseErrorFormat {
    FAIL_DIVISION_BY_ZERO("0으로는 나눌 수 없습니다."),
    FAIL_WRONG_INPUT_FORMULA("잘못된 연산자입니다."),
    FAIL_WRONG_INPUT_MENU("잘못된 메뉴입니다."),
    FAIL_WRONG_INPUT_SYMBOL("잘못된 연산식입니다."),
    FAIL_UNSPECIFIED_EXCEPTION("명시된 예외가 아닙니다. ->"),
    ;

    private String message;

    ResponseErrorFormat(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}