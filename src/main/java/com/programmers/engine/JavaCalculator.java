package com.programmers.engine;

import com.programmers.BasicCalculator;
import com.programmers.engine.io.Input;
import com.programmers.engine.io.Output;
import com.programmers.engine.model.Result;

public class JavaCalculator {
    private final Input input;
    private final Output output;
    private final Result result;
    private final BasicCalculator bc = new BasicCalculator();

    public JavaCalculator(Input input, Output output, Result result) {
        this.input = input;
        this.output = output;
        this.result = result;
    }

    public void run() {
        boolean isExcutable = true;
        while (isExcutable) {
            output.showMenu();
            switch (input.selectMenu()) {
                case 1 -> result.readAllResults();
                case 2 -> result.save(bc.doCalculate(input.getExpression()));
                case 3 -> isExcutable = false;
                default -> System.out.println("다시 선택해주세요!");
            }
        }
    }
}
