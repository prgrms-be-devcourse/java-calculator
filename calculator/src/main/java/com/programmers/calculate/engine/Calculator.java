package com.programmers.calculate.engine;

import com.programmers.calculate.engine.io.Input;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable {
    Input input;


    @Override
    public void run() {
        input.selectNumber();
    }
}
