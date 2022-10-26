package com.programmers.java.engine.option;

import com.programmers.java.application.Console;
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
    public void runOption() {
        Equation equation = useCalculator();

        historyRepository.save(equation);
    }

    private Equation useCalculator() {
        String inputExpression = console.input("\n");
        Expression expression = calculator.parseExpression(inputExpression);

        Answer answer = calculator.calculate(expression);
        console.printAnswer(answer);

        return Equation.builder()
                .expression(inputExpression)
                .answer(answer)
                .build();
    }
}
