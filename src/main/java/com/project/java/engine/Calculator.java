package com.project.java.engine;

import com.project.java.engine.io.Input;
import com.project.java.engine.io.Output;
import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class Calculator {
    private static final String MESSAGE = "번호를 입력해주세요 : ";
    private static final String MESSAGE_EXPRESSION = "계산식을 입력해주세요 : ";
    private int result;
    private Input input;
    private Output output;

    public void run() throws IOException {

        while(true) {
            String cmd = input.getInput(MESSAGE);
            switch(cmd) {
                case "1" :
                    break;
                case "2" :
                    String expression = input.getExpression(MESSAGE_EXPRESSION);
                    if(!input.validateInput(expression)) {
                        System.out.println("ERROR");
                        continue;
                    }

                    break;
                default:
                    output.inputError();
            }
        }
    }
}
