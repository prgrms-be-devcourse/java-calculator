package calculator.io;

public enum Characters {
    BLANK(" "),
    DOT(".");

    private final String character;

    Characters(String character) {
        this.character = character;
    }

    public String toLiteral() {
        return character;
    }
}
