package calculator.application.io.enums;

public enum Message {
    SELECT("선택 : ");

    private final String literal;

    Message(String literal) {
        this.literal = literal;
    }

    @Override
    public String toString() {
        return literal;
    }
}
