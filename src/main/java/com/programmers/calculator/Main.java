package com.programmers.calculator;

import com.programmers.calculator.engine.Calculator;
import com.programmers.calculator.engine.conversion.Conversion;
import com.programmers.calculator.engine.conversion.ConversionFormula;
import com.programmers.calculator.engine.io.Console;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        Conversion conversion = new ConversionFormula();


        new Calculator(console, console, conversion).run();
    }
}