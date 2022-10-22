package com.programmers.java;

import com.programmers.java.calculator.Calculator;
import com.programmers.java.data.Store;
import com.programmers.java.io.Console;

import java.io.IOException;

public class App {
    static Store store = new Store();
    public static void main(String[] args){
        Console console = new Console();
        //Store store = new Store();

        new Calculator(console, console, store).run();
    }
}
