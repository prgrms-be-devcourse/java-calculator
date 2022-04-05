package com.programmers;

import com.programmers.io.Console;
import com.programmers.model.Calculator;
import com.programmers.model.Expression;
import com.programmers.repository.ExpressionRepository;
import com.programmers.repository.MemoryExpressionRepository;

import java.util.List;

public class Application {
    private static final int SELECT_CHOICE = 1;
    private static final int CALCULATE_CHOICE = 2;

    public static void main(String[] args) {
        Console console = new Console();
        ExpressionRepository expressionRepository = new MemoryExpressionRepository();
        int choice;

        do {
            choice = console.choiceInput();
            if(choice == SELECT_CHOICE) {
                List<Expression> expressions = expressionRepository.findAll();
                console.printAllExpressions(expressions);
            } else if(choice == CALCULATE_CHOICE) {
                String exprInput = console.expressionInput();
                Expression expression = new Expression(exprInput);

                double resultNum = Calculator.calculate(expression);
                expression.setCalcResult(resultNum);

                expressionRepository.save(expression);
                console.printCalculatedNumber(expression.getCalcResult());
            }
        } while (choice == SELECT_CHOICE || choice == CALCULATE_CHOICE);

        console.printExit();
    }

}
