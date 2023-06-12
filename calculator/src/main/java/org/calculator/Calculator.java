package org.calculator;

import lombok.AllArgsConstructor;
import org.calculator.engine.CalculateEngine;
import org.calculator.engine.domain.Condition;
import org.calculator.engine.error.ErrorCode;
import org.calculator.engine.io.Console;
import org.calculator.repository.CalculateRepository;

@AllArgsConstructor
public class Calculator implements Runnable {
    private static boolean STOPPER = true;
    private CalculateEngine calculateEngine;
    private Console console;
    private CalculateRepository calculateRepository;

    @Override
    public void run() {
        runCalculator();
    }

    private void runCalculator() {
        while (STOPPER) {
            String stringCondition = validateInput();
            Condition condition = validateCondition(stringCondition);
            inquireHistory(condition);
            calculate(condition);
            stop(condition);
        }
    }

    private String validateInput() {
        String stringCondition = console.printCondition().orElse("wrong");
        if (stringCondition == "wrong") {
            console.printError(ErrorCode.BAD_CONDITION);
        }
        return stringCondition;
    }

    private Condition validateCondition(String stringCondition) {
        Condition condition = Condition.decideCondition(stringCondition).orElse(null);
        if (condition == null) {
            console.printError(ErrorCode.BAD_CONDITION);
        }
        return condition;
    }



    private void inquireHistory(Condition condition) {
        if (condition == Condition.LOOKUP) {
            System.out.println();
            System.out.println("<< History Of Calculation >>");
            calculateRepository.getHistory()
                    .forEach(h -> System.out.println("Equation : " + h.getEquation() + " | result : " + h.getResult()));
            System.out.println();
        }
    }

    private void calculate(Condition condition) {
        if (condition == Condition.CALCULATE) {
            String equation = console.insertEquation();
            double result = calculateEngine.calculate(equation);
            System.out.println();
            System.out.println("result = " + result);
            System.out.println();
        }
    }

    private void stop(Condition condition) {
        if (condition == Condition.BREAK) {
            STOPPER = false;
        }
    }
}
