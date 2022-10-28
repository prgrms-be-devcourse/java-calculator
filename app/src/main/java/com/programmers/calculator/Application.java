package com.programmers.calculator;

import com.programmers.calculator.io.Console;
import com.programmers.calculator.processor.Calculator;
import com.programmers.calculator.storage.OperationMemoryStorage;

public class Application {
    public static void main(String[] args) {
        new Main(new OperationMemoryStorage(), new Console(), new Calculator(), new ModeExcuter()).run();
    }
}
