package com.programmers;

import com.programmers.io.Console;
import com.programmers.model.Calculator;
import com.programmers.model.Expression;
import com.programmers.repository.ExpressionRepository;
import com.programmers.repository.MemoryExpressionRepository;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        ExpressionRepository expressionRepository = new MemoryExpressionRepository();

        while(true) {
            int choice = console.choiceInput();
            if(choice == 1) {
                List<Expression> expressions = expressionRepository.findAll();
                console.printAllExpressions(expressions);
            } else if(choice == 2) {
                String exprInput = console.expressionInput();
                Expression expression = new Expression(exprInput);

                double resultNum = Calculator.calculate(expression);
                expression.setCalcResult(resultNum);

                expressionRepository.save(expression);
                console.printCalculatedNumber(expression.getCalcResult());
            } else {
                console.printChooseWrongNumber();
                break;
            }
        }
    }

}
