package com.programmers;

import com.programmers.engine.Calculator;
import com.programmers.engine.PostfixCalculator;
import com.programmers.io.Console;
import com.programmers.validator.Validator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.run();

    }

    public Console getConsole() {
        return new Console();
    }

    public PostfixCalculator getPostfixCalculator() {
        return new PostfixCalculator();
    }

}
