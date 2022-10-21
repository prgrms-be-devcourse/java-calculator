package calculator.engine.io;

import java.util.List;

public enum SelectOption {
    CALCULATE(1, "계산"),
    INQUIRY(2, "조회");

    private final Integer index;
    private final String option;

    SelectOption(Integer index, String option) {
        this.index = index;
        this.option = option;
    }

    private String toLiteral() {
        return option;
    }

    public static List<String> getLiterals() {
        
    }
}
