package calculator.exception;

public enum OperatorException {

    OPERATOR_CALCULATION_EXCEPTION_DIVIDE_ZERO("0으로 나누는 연산 중에 오류가 발생하였습니다."),
    OPERATORS_EXCEPTION_NULL_FIND("찾을 수 없는 연산자로 오류가 발생하였습니다.");

    private final String message;

    OperatorException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
