package com.devcourse;

import com.devcourse.engine.computer.SimpleComputer;
import com.devcourse.engine.Calculator;
import com.devcourse.engine.historian.Historian;
import com.devcourse.engine.io.InputConsole;
import com.devcourse.engine.io.OutputConsole;

public class App {
    public static void main(String[] args) {

        new Calculator(
                new SimpleComputer(),
                new Historian(),
                new InputConsole(),
                new OutputConsole()
        ).run();
    }

}