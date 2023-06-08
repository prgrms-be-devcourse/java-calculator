package display;

public enum Message {
    DISPLAY_SELECT("1. 조회"),
    DISPLAY_CALCULATION("2. 계산"),
    DISPLAY_EXIT("3. 종료"),
    DISPLAY_CHOOSE("선택 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
