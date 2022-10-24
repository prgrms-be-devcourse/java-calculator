package calculator.application.io.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SelectOption {
    CALCULATE(1, "계산"),
    QUERY(2, "조회"),
    EXIT(0, "종료");

    private final Integer index;
    private final String literal;

    SelectOption(Integer index, String literal) {
        this.index = index;
        this.literal = literal;
    }

    public static List<String> getLiterals() {
        return Arrays.stream(SelectOption.values())
                .map(SelectOption::toString)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(index)
                .append(Characters.DOT)
                .append(Characters.BLANK)
                .append(literal)
                .toString();
    }

    public Integer getIndex() {
        return index;
    }
}
