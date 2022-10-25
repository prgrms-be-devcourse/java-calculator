package com.programmers.java.engine;

import com.programmers.java.application.Console;
import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Equation;
import com.programmers.java.engine.model.Expression;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class Menu implements Runnable {
    private Console console;
    private Calculator calculator;
    private HistoryRepository historyRepository;

    @Override
    public void run() {
        // Loop
        while (true) {
            // input option
            String inputOption = this.console.input("1. 조회\n2. 계산\n\n선택 : ");

            // check validate
            Optional<Integer> option = calculator.parseOption(inputOption);
            // incorrect -> continue
            if (option.isEmpty()) {
                console.inputError();
                continue;
            }

            // Option 1. Show history
            if (option.get().equals(1)) {
                String inputHistory = historyRepository.findAll();

                console.printHistory(inputHistory);
            }

            // Option 2. Use calculator
            if (option.get().equals(2)) {
//                if (expression.isEmpty()) {
//                    console.inputError();
//                    continue;
//                }
                // 계산
                Equation equation = useCalculator();

                // 계산 저장
                historyRepository.save(equation);
            }

        }
    }

    private Equation useCalculator() {
        String inputExpression = this.console.input("\n");
        Optional<Expression> expression = calculator.parseExpression(inputExpression);

        // 계산
        Answer answer = calculator.calculate(expression.get());
        console.printAnswer(answer);

        return Equation.builder()
                .expression(inputExpression)
                .answer(answer)
                .build();
    }
}
