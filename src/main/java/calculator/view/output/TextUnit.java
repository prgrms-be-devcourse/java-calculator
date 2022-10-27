package calculator.view.output;

public enum TextUnit {

    DOT("."),
    SPACE(" "),
    NO_SPACE(""),
    EQUAL("="),
    ENTER("\n");

    private final String unit;

    TextUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
