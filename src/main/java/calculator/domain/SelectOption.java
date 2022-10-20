package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SelectOption {
    CALCULATE("계산"),
    INQUIRY("조회");

    private final String literal;

    SelectOption(String literal) {
        this.literal = literal;
    }

    private String toLiteral() {
        return literal;
    }

    public static List<String> getLiterals() {
        return Arrays.stream(SelectOption.values())
                .map(SelectOption::toLiteral)
                .collect(Collectors.toList());
    }
}
