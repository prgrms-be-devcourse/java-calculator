package calculator.application.io.enums;

public enum Message {
    INPUT_SELECT_GUIDE("선택 : "),
    INPUT_EXPRESSION_GUIDE("식 입력 : "),
    RESULT_GUIDE("계산 결과 : "),

    EMPTY_HISTORY_ALERT("계산 이력이 없습니다."),
    EXIT_ALERT("애플리케이션이 종료됩니다.");

    private final String literal;

    Message(String literal) {
        this.literal = literal;
    }

    @Override
    public String toString() {
        return literal;
    }
}
