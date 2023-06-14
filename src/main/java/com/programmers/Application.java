package com.programmers;

import com.programmers.calculator.controller.CalculatorController;
import com.programmers.calculator.domain.Calculator;
import com.programmers.calculator.domain.Expression;
import com.programmers.calculator.view.InputConsole;
import com.programmers.calculator.view.OutputConsole;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        new CalculatorController(
                new InputConsole(new Scanner(System.in)),
                new OutputConsole(),
                new Calculator(new Expression())
        ).run();
    }
}
