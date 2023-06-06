package org.programmers.java;

import org.programmers.java.calculate.Calculate;
import org.programmers.java.console.Console;
import org.programmers.java.validation.Validation;

public class App {
    public static void main(String[] args){
        Console console = new Console(new Validation());
        Calculate calculate = new Calculate();
        Calculator calculator = new Calculator(console, console, calculate);
        calculator.run();
    }
}
