package com.devcourse;

import com.devcourse.computer.Computer;
import com.devcourse.engine.Calculator;
import com.devcourse.historian.Historian;

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