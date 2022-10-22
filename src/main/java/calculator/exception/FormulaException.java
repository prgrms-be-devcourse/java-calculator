package calculator.exception;

public enum FormulaException {

    FORMULA_BASIC_PARSER_EXCEPTION("연산식에 계산할 수 없는 문자가 있습니다.");

    public final String message;

    FormulaException(String message) {
        this.message = message;
    }

}
