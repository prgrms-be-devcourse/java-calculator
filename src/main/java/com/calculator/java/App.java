package com.calculator.java;


import com.calculator.java.database.Database;
import com.calculator.java.engine.Calculator;
import com.calculator.java.engine.comand.CommandTypes;

public class App {
    public static void main(String[] args)  {
         Console console = new Console(new Validation(CommandTypes.values()));
         Database database = new Database();

         Calculator calculator = new Calculator(console, database);
         calculator.run();
    }
}
