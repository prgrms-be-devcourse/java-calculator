package com.programmers.java;

import com.programmers.java.engine.Calculator;
import com.programmers.java.engine.model.Expression;
import com.programmers.java.engine.model.History;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        Console console=new Console();
        History history=new History(new ArrayList<Expression>());
        new Calculator(console, console, history).run();
    }
}
