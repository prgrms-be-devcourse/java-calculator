package calculator.vo;

import calculator.constant.ErrorMessage;

public class Option {
    private final String option;
    private final String OPTION_PATTERN = "^(1|2)$";

    public Option(String option) {
        validate(option);
        this.option = option;
    }

    public String get() {
        return option;
    }

    private void validate(String input) {
        if (!input.matches(OPTION_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_OPTION);
        }
    }

}
