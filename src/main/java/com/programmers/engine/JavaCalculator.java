package com.programmers.engine;

import com.programmers.BasicCalculator;
import com.programmers.engine.io.Input;
import com.programmers.engine.io.Output;
import com.programmers.engine.model.Menu;
import com.programmers.engine.model.ResultManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JavaCalculator implements Runnable{
    private final Input input;
    private final Output output;
    private final ResultManager resultManager;
    private final BasicCalculator bc;

    @Override
    public void run() {
        while (true) {
            output.showMenu();
            Menu menu = Menu.matchMenu(input.selectMenu());

            switch (menu) {
                case LOOK_UP -> output.readAllResults(resultManager.readAllResults());
                case CALCULATE -> calculate();
                case EXIT -> {
                    return;
                }
                default -> output.inputError();
            }
        }
    }

    private void calculate() {
        String expression = input.getExpression();
        int answer = bc.doCalculate(expression);
        output.printAnswer(answer);
        resultManager.save(expression, answer);
    }
}
