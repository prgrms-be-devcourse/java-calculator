package calculator.application.io.enums;

public enum Characters {
    BLANK(" "),
    DOT(".");

    private final String character;

    Characters(String character) {
        this.character = character;
    }

    @Override
    public String toString() {
        return character;
    }
}
