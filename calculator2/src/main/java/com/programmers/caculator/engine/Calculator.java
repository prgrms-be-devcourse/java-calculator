package com.programmers.caculator.engine;

import com.programmers.caculator.engine.io.Input;
import com.programmers.caculator.engine.io.Output;


public class Calculator implements Runnable {

    Input input;
    Output output;

    @Override
    public void run() {
        input.selectNumber();


    }
}
