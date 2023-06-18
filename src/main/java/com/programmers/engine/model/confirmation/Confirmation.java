package com.programmers.engine.model.confirmation;

import com.programmers.engine.exception.CalculatorErrorCode;
import com.programmers.engine.exception.CalculatorException;

import java.util.regex.Pattern;

public class Confirmation {

    public boolean isOperand(String element) {
        return element.matches("[0-9]+");
    }

    public boolean isOperator(String element) {
        return element.matches("[+\\-*/]");
    }

    public void validateCalculationCommand(String calculationCommand) {
        if (Pattern.compile(" ")
                .splitAsStream(calculationCommand)
                .filter(e -> !(isOperator(e) || isOperand(e)))
                .findAny()
                .isPresent() || !calculationCommand.contains(" ")) {
            throw new CalculatorException(CalculatorErrorCode.COMMAND_ERROR);
        }
    }
}
