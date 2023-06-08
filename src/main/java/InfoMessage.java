public enum InfoMessage {
    COMMAND_ONE("1. 조회"), COMMAND_TWO("2. 계산"), SELECT("선택 : ");

    private final String message;

    InfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
