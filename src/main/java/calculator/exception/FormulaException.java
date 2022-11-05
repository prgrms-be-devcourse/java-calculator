package calculator.exception;

public enum FormulaException {

    FORMULA_BASIC_PARSER_EXCEPTION("연산식에 계산할 수 없는 문자가 있습니다."),
    FORMULA_BASIC_NULL_EXCEPTION("잘못된 연산식으로 파싱할 문자를 찾을 수 없습니다.");

    private final String message;

    FormulaException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
