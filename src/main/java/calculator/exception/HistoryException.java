package calculator.exception;

public enum HistoryException {

    HISTORY_SAVE_EXCEPTION("저장 중에 오류가 발생하였습니다."),
    HISTORY_SAVE_OVERLAP_EXCEPTION("이전에 저장한 연산식으로 오류가 발생하였습니다.");

    private final String message;

    HistoryException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
