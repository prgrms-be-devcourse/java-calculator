package calculator;

import java.util.Arrays;

public class InputParser {
    private InputValidator inputValidator;
    private final String seperator;

    InputParser() {
        this.inputValidator = new InputValidator();
        this.seperator = " ";
    }

    public String[] parse(String inputFormula) {
        if (inputFormula == null) throw new IllegalArgumentException();
        String[] splittedInputFormula = inputFormula.split(seperator);

        if (!inputValidator.valid(splittedInputFormula)) throw new IllegalArgumentException();

        return PostfixConvertor.convert(splittedInputFormula);
    }
}
