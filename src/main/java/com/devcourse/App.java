package com.devcourse;

import com.devcourse.engine.computer.SimpleComputer;
import com.devcourse.engine.Calculator;
import com.devcourse.engine.converter.PostfixConverter;
import com.devcourse.engine.historian.Historian;
import com.devcourse.engine.io.InputConsole;
import com.devcourse.engine.io.OutputConsole;
import com.devcourse.engine.validator.SimpleValidator;

public class App {
    public static void main(String[] args) {

        new Calculator(
                new InputConsole(),
                new OutputConsole(),
                new Historian(),
                new SimpleValidator(),
                new PostfixConverter(),
                new SimpleComputer()
        ).run();
    }

}