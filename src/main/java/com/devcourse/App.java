package com.devcourse;

import com.devcourse.engine.model.computer.SimpleComputer;
import com.devcourse.engine.Calculator;
import com.devcourse.engine.model.converter.PostfixConverter;
import com.devcourse.engine.model.histories.Histories;
import com.devcourse.engine.io.InputConsole;
import com.devcourse.engine.io.OutputConsole;
import com.devcourse.engine.model.validator.SimpleValidator;

public class App {
    public static void main(String[] args) {

        new Calculator(
                new InputConsole(),
                new OutputConsole(),
                new Histories(),
                new SimpleValidator(),
                new PostfixConverter(),
                new SimpleComputer()
        ).run();
    }

}