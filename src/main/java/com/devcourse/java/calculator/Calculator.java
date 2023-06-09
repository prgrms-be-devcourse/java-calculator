package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.MenuConstant;
import com.devcourse.java.calculator.io.Input;
import com.devcourse.java.calculator.io.Output;
import com.devcourse.java.calculator.repository.CalculatorRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable{

    private final Input input;
    private final Output output;
    private final CalculatorRepository calculatorRepository;

    @Override
    public void run() {

        while (true) {
            output.printCommandMenu();
            int command = input.getCommand();

            if (command == MenuConstant.SELECTED_EXIT_COMMAND) {
                return;
            }
            runCommand(command);
        }

    }

    public void runCommand(int command) {
        if (command == MenuConstant.SELECTED_HISTORY_COMMAND) {

            // 조회
        }

        else if (command == MenuConstant.SELECTED_CALCULATE_COMMAND) {

            // 계산
        }
    }
}
