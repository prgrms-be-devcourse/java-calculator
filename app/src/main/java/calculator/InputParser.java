package calculator;

import java.util.Arrays;

public class InputParser {
    private static String seperator = " ";
    public static String[] parse(String inputFormula) {
        if(inputFormula == null) throw new IllegalArgumentException();
        String[] splitedInputFormula = inputFormula.split(seperator);

        if(!InputValidator.valid(splitedInputFormula)) throw new IllegalArgumentException();

        return PostfixConvertor.convert(splitedInputFormula);
    }
}
