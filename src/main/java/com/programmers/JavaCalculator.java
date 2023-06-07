package com.programmers;

import com.programmers.model.Input;
import com.programmers.model.Output;
import com.programmers.model.Result;

public class JavaCalculator {
    private final Input input;
    private final Output output;
    private final Result result;

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
                case 3 -> isExcutable = false;
                default -> System.out.println("다시 선택해주세요!");
            }
        }
    }
}
