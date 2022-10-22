package calculator.calculator.formula;

public enum ParseUnit {

    SPACE(" "),
    NO_SPACE("");

    public final String unit;

    ParseUnit(String unit) {
        this.unit = unit;
    }
}
