package com.devcourse;

import com.devcourse.engine.computer.Computer;
import com.devcourse.engine.Calculator;
import com.devcourse.engine.historian.Historian;

public class App {
    public static void main(String[] args) {

        new Calculator(
                new Computer(),
                new Historian(),
                new InputConsole(),
                new OutputConsole()
        ).run();
    }

}