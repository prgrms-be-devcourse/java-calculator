package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.MenuConstant;
import com.devcourse.java.calculator.io.Input;
import com.devcourse.java.calculator.io.Output;
import com.devcourse.java.calculator.repository.CalculatorRepository;
import lombok.AllArgsConstructor;

import java.util.InputMismatchException;

@AllArgsConstructor
public class Calculator implements Runnable{

    private final Input input;
    private final Output output;
    private final CalculatorRepository calculatorRepository;
    private int command;

    @Override
    public void run() {

        while (true) {
            output.printCommandMenu();

            try {
                command = input.getCommand();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                continue;
            }

            if (command == MenuConstant.SELECTED_EXIT_COMMAND) {
                return;
            }
            runCommand(command);
            return; // 지우기
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
