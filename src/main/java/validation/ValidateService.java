package validation;

import java.util.regex.Pattern;

public class ValidateService{

    private final String operatorReg = "[1-3]";
    private final String formulaReg = "^(\\d*\s[-+*/]\\s)+(\\d+)";

    public boolean isCorrectFormula(String formula) {
        return Pattern.matches(formulaReg,formula);
    }

    public boolean isCorrectCommand(String command) {
        return Pattern.matches(operatorReg,command);
    }
}
