package com.programmers;

import com.programmers.engine.Calculator;
import com.programmers.engine.model.DataBase;
import com.programmers.engine.model.Formula;
import com.programmers.engine.validate.BracketValidator;
import com.programmers.engine.validate.NumOperatorValidator;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        DataBase dataBase = new DataBase();
        Formula formula = new Formula();
        BracketValidator validator1 = new BracketValidator();
        NumOperatorValidator validator2 = new NumOperatorValidator();

        //new Calculator(console, console, validator1, validator2, dataBase, formula).run();
        new Calculator(console, console, dataBase, formula, validator1, validator2).run();
    }
}