package com.programmers.engine;

import com.programmers.BasicCalculator;
import com.programmers.engine.io.Input;
import com.programmers.engine.io.Output;
import com.programmers.engine.model.Result;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JavaCalculator implements Runnable{
    private final Input input;
    private final Output output;
    private final Result result;
    private final BasicCalculator bc;

    @Override
    public void run() {
        boolean isExecutable = true;
        while (isExecutable) {
            output.showMenu();
            switch (input.selectMenu()) {
                case 1 -> output.readAllResults(result.readAllResults());
                case 2 -> {
                    String expression = input.getExpression();
                    int answer = bc.doCalculate(expression);
                    output.printAnswer(answer);
                    result.save(expression, answer);
                }
                case 3 -> isExecutable = false;
                default -> output.inputError();
            }
        }
    }
}
