package com.programmers;

import com.programmers.engine.Calculator;
import com.programmers.engine.model.DataBase;
import com.programmers.engine.model.Formula;

public class App {
    public static void main(String[] args) {
        System.out.println("안녕!! ");

        Console console = new Console();
        DataBase dataBase = new DataBase();
        Formula formula = new Formula();

        new Calculator(console, console, dataBase, formula).run();
    }
}