package org.programmers.java;

import org.programmers.java.console.Console;
import org.programmers.java.validation.Validation;

public class App {
    public static void main(String[] args){
        Console console = new Console(new Validation());
        Calculator calculator = new Calculator(console, console);
        calculator.run();
    }
}
