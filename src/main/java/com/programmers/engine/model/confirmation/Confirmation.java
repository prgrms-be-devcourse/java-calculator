package com.programmers.engine.model.confirmation;

import java.util.regex.Pattern;

public class Confirmation {

    public static boolean isOperand(String element) {
        return element.matches("[0-9]+");
    }

    public static boolean isOperator(String element) {
        return element.matches("[+\\-*/]");
    }

    public void validateCalculationCommand(String calculationCommand) {
        if (Pattern.compile(" ")
                .splitAsStream(calculationCommand)
                .filter(e -> !(Confirmation.isOperator(e) || Confirmation.isOperand(e)))
                .findAny()
                .isPresent()) {
            throw new IllegalArgumentException("잘못된 계산식 입니다.");
        }
    }
}
