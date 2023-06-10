package org.example;


import org.example.engine.Calculator;

public class App {
    public static void main(String[] args) {

        Console console = new Console();
        new Calculator(console).run();

    }

}



