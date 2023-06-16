package calculator.vo;

import calculator.constant.ErrorMessage;

public class OptionVO {
    private final String option;
    private final String OPTION_PATTERN = "^(1|2)$";

    public OptionVO(String option) {
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
