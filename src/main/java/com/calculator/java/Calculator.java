package com.calculator.java;


import com.calculator.java.console.Console;
import com.calculator.java.console.Validation;
import com.calculator.java.database.Database;

// 개선해 봅시다.
public class Calculator {
    public static void main(String[] args)  {

         Console console = new Console(new Validation(), new Database());
         console.run();

    }
}
