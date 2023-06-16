package com.devcourse;

import com.devcourse.engine.model.accepter.Accepter;
import com.devcourse.engine.model.computer.Computer;
import com.devcourse.engine.Calculator;
import com.devcourse.engine.model.converter.Converter;
import com.devcourse.engine.model.histories.Histories;
import com.devcourse.engine.io.InputConsole;
import com.devcourse.engine.io.OutputConsole;

public class App {
    public static void main(String[] args) {

        new Calculator(
                new InputConsole(),
                new OutputConsole(),
                new Histories(),
                new Accepter(),
                new Converter(),
                new Computer()
        ).run();
    }

}