package org.calculator;

import lombok.AllArgsConstructor;
import org.calculator.engine.CalculateEngine;
import org.calculator.engine.domain.Condition;
import org.calculator.engine.io.Console;

@AllArgsConstructor
public class Calculator implements Runnable {
    private static boolean STOPPER = true;
    private CalculateEngine calculateEngine;
    private Console console;

    @Override
    public void run() {
        runCalculator();
    }

    private void runCalculator() {
        while (STOPPER) {
            Condition condition = null;
            condition = getUserInput(condition);
            printHistory(condition);
            calculate(condition);
            if (condition == Condition.BREAK) break;
        }
    }

    private Condition getUserInput(Condition condition) {
        try {
            condition = console.getCondition();
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString());
        }
        return condition;
    }

    private void printHistory(Condition condition) {
        if (condition == Condition.LOOKUP) {
            console.printHistory();
        }
    }

    private void calculate(Condition condition) {
        if (condition == Condition.CALCULATE) {
            String equation = console.insertEquation();
            double result = 0;
            try {
                result = calculateEngine.calculate(equation);
                console.printAnswer(result);
            } catch (Exception e) {
                System.out.println("계산에 문제가 생겼습니다. 문제 원인 : " + e.toString());
                System.out.println();
            }

        }
    }

}
