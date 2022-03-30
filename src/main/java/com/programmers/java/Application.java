package com.programmers.java;
import com.programmers.java.engine.io.Console;

public class Application {
    public static void main(String[] args){
        Console console = new Console();
        new Calculator(console,console).run();
    }
}
