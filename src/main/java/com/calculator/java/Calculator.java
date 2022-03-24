package com.calculator.java;


import com.calculator.java.console.Console;
import com.calculator.java.console.Validation;
import com.calculator.java.database.Database;

public class Calculator {
    public static void main(String[] args)  {

         Console console = new Console(new Validation(), new Database());
         console.run();

    }
}
