package org.calculator;

import lombok.AllArgsConstructor;
import org.calculator.engine.domain.Condition;
import org.calculator.engine.error.ErrorCode;
import org.calculator.engine.io.Input;
import org.calculator.engine.io.Output;

@AllArgsConstructor
public class Calculator implements Runnable {
    private static boolean STOPPER = true;
    private Input input;
    private Output output;
    @Override
    public void run() {
        while (STOPPER) {
            String stringCondition = validateInput();
            Condition condition = validateCondition(stringCondition);
            inquireHistory(condition);
            calculate(condition);
            stop(condition);

        }
    }

    private String validateInput() {
        String stringCondition = input.printCondition().orElse("wrong");
        if (stringCondition == "wrong") {
            output.printError(ErrorCode.BAD_CONDITION);
        }
        return stringCondition;
    }

    private Condition validateCondition(String stringCondition) {
        Condition condition = Condition.decideCondition(stringCondition).orElse(null);
        if (condition == null) {
            output.printError(ErrorCode.BAD_CONDITION);
        }
        return condition;
    }



    private static void inquireHistory(Condition condition) {
        if (condition == Condition.LOOKUP) {
            System.out.println("Calculator.LOOKUP");;
        }
    }

    private static void calculate(Condition condition) {
        if (condition == Condition.CALCULATE) {
            System.out.println("Calculator.CALCULATE");
        }
    }

    private static void stop(Condition condition) {
        if (condition == Condition.BREAK) {
            STOPPER = false;
        }
    }
}
