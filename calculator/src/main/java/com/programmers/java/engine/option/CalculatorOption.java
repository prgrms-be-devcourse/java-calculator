package com.programmers.java.engine.option;

import com.programmers.java.application.Console;
import com.programmers.java.application.exception.OnlyNumberException;
import com.programmers.java.engine.calculator.Calculator;
import com.programmers.java.engine.history.HistoryRepository;
import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Equation;
import com.programmers.java.engine.model.Expression;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CalculatorOption implements Option {
    private Console console;
    private HistoryRepository historyRepository;
    private Calculator calculator;

    @Override
    public void runOption() throws Exception {
        Equation equation = useCalculator();

        historyRepository.save(equation);
    }

    private Equation useCalculator() throws Exception {
        Answer answer;
        Expression expression;

        String inputExpression = console.input("\n");
        try {
            expression = calculator.parseExpression(inputExpression);

            answer = calculator.getAnswer(expression);
        } catch (OnlyNumberException exception) {
            expression = Expression.builder()
                    .tokens(new String[]{inputExpression})
                    .build();

            answer = Answer.builder()
                    .value(Double.parseDouble(inputExpression))
                    .build();
        }

        console.printAnswer(answer);

        return Equation.builder()
                .expression(expression)
                .answer(answer)
                .build();
    }
}
