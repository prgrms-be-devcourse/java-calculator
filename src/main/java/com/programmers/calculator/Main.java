package com.programmers.calculator;

import com.programmers.calculator.engine.calculation.Calculate;
import com.programmers.calculator.engine.calculation.CalculatePostfix;
import com.programmers.calculator.engine.conversion.Conversion;
import com.programmers.calculator.engine.conversion.ConversionFormula;
import com.programmers.calculator.engine.io.Console;
import com.programmers.calculator.engine.storage.LocalMemoryStorage;
import com.programmers.calculator.engine.storage.Storage;

public class Main {
    public static void main(String[] args) {
        Console console = new Console();
        Conversion conversion = new ConversionFormula();
        Calculate calculate = new CalculatePostfix();
        Storage storage = new LocalMemoryStorage();


        new Calculator(console, console, conversion, calculate, storage).run();
    }
}