package calculator.domain.model;

public enum Message {

    MENU("1. 조회\n2. 계산\n3. 종료\n\n입력: "),
    EXIT("\n계산기를 종료합니다."),
    CALCULATION_RESULT("%s = %s"),
    ;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public static String calculationResult(HistoryModel historyModel) {
        return String.format(CALCULATION_RESULT.message, historyModel.getFormula(), historyModel.getFormula());
    }
}
