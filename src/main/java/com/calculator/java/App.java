package com.calculator.java;


import com.calculator.java.console.Console;
import com.calculator.java.console.Validator;
import com.calculator.java.engine.Calculator;
import com.calculator.java.global.Enum.CommandTypes;

public class App {
    public static void main(String[] args)  {
         Console console = new Console(new Validator(CommandTypes.values()));
         Calculator calculator = new Calculator(console);

         calculator.run();
    }
}
