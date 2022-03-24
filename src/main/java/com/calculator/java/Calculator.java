package com.calculator.java;


import com.calculator.java.domain.console.Console;
import com.calculator.java.domain.console.Validation;
import com.calculator.java.domain.database.Database;

public class Calculator {
    public static void main(String[] args)  {

        Console console = new Console(new Validation(), new Database());
        console.run();

    }
}
