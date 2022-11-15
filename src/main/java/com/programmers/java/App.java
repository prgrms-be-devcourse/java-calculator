package com.programmers.java;

import com.programmers.java.engin.Calculator;
import com.programmers.java.engin.io.Calculation;
import com.programmers.java.engin.PostfixCalculation;
import com.programmers.java.engin.model.LogGroups;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        Calculation calculation = new PostfixCalculation();
        Console console = new Console();
        LogGroups logGroups = new LogGroups(new ArrayList<>());
        new Calculator(calculation,console,console, logGroups).run();
    }
}
