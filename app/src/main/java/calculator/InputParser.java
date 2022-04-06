package calculator;

import java.util.Arrays;

public class InputParser {
    private final InputValidator inputValidator;
    private final String seperator;

    public InputParser() {
        this.inputValidator = new InputValidator();
        this.seperator = " ";
    }

    public String[] parse(String inputFormula) {
        if (inputFormula == null) {
            throw new IllegalArgumentException("계산식이 입력되지 않았습니다.");
        }
        String[] splittedInputFormula = inputFormula.split(seperator);

        if (!inputValidator.valid(splittedInputFormula)) {
            throw new IllegalArgumentException("적합하지 않은 입력입니다.");
        }

        return PostfixConvertor.convert(splittedInputFormula);
    }
}
