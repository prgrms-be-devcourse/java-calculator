package calculator.view.output;

public enum TextUnit {

    DOT("."),
    SPACE(" "),
    ENTER("\n");

    public final String unit;

    TextUnit(String unit) {
        this.unit = unit;
    }
}
