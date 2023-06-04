package org.programmers.java;

import org.programmers.java.console.Console;

public class App {
    public static void main(String[] args){
        Console console = new Console();
        Calculator calculator = new Calculator(console, console);
        calculator.run();
    }
}
