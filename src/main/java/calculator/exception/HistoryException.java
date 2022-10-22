package calculator.exception;

public enum HistoryException {

    HISTORY_SAVE_EXCEPTION("저장 중에 오류가 발생하였습니다.");

    public final String message;

    HistoryException(String message) {
        this.message = message;
    }
}
