package com.project.java.engine;

import com.project.java.engine.io.Input;
import com.project.java.engine.io.Output;
import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class Calculator {
    private final String GREETING = "번호를 입력해주세요.";
    private int result;
    private Input input;
    private Output output;

    public void run() throws IOException {

        while(true) {
            String cmd = input.getInput(GREETING);
            switch(cmd) {
                case "1" :
                    break;
                case "2" :
                    break;
            }

        }
    }
}
