package com.programmers.calculator.controller;

import com.programmers.calculator.engine.Console;
import com.programmers.calculator.engine.Calculator;
import com.programmers.calculator.engine.io.Input;
import com.programmers.calculator.engine.io.Output;
import com.programmers.calculator.engine.repository.Repository;

import java.util.List;
import java.util.Optional;

public class Controller {
    private final Calculator calculator = new Calculator();
    private final Input input;
    private final Output output;

    public Controller() {
        Console console = new Console();
        input = console;
        output = console;
    }

    public void start() {
        while (true) {
            String inputMenu = input.input("1. 조회\n2. 계산\n3. 종료\n\n선택 : ");
            output.printEnter();
            boolean close = false;
            switch (inputMenu) {
                case "1":
                    Optional<List<String>> data = calculator.getData();
                    if(!data.isPresent()) {
                        output.emptyError();
                    } else {
                        output.printRepository(data.get());
                    }
                    break;
                case "2":
                    String expression = input.input("수식 입력 : ");
                    Optional<Integer> result = calculator.calculate(expression);
                    if (!result.isPresent()) { // 예외 처리
                        output.inputError();
                    } else {
                        output.printResult(result.get()); // 결과 출력
                    }
                    break;
                case "3":
                    close = true;
                    break;
                default:
                    output.inputError();
                    break;
            }

            if (close) break;

            output.printEnter();
        }
    }
}