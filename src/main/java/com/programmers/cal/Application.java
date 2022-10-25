package com.programmers.cal;

import com.programmers.cal.engine.Calculator;
import com.programmers.cal.engine.io.Console;
import com.programmers.cal.engine.parse.ExpressionParse;
import com.programmers.cal.engine.validator.ExpressionValidator;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();

        new Calculator(console, console, new ExpressionValidator(), new ExpressionParse()).run();
    }
}