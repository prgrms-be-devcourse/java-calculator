package calculator.calculator.formula;

public enum ParseUnit {

    SPACE(" "),
    NO_SPACE("");

    private final String unit;

    ParseUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }
}
