package validation;

import java.util.regex.Pattern;

public class ValidateService implements Validate{

    private final String operatorReg = "[1-3]";
    private final String formulaReg = "^(\\d*\s[-+*/]\\s)+(\\d+)";

    @Override
    public boolean isCorrectFormula(String formula) {

        return Pattern.matches(formulaReg,formula);
    }
    @Override
    public boolean isCorrectCommand(String command) {
        return Pattern.matches(operatorReg,command);
    }
}
