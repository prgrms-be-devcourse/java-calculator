package org.example;

import org.example.calculation.ArithmeticCalculation;
import org.example.calculation.Calculation;
import org.example.io.IoManager;

public class Main {
    public static void main(String[] args) {
//        IoManager ioManager = new IoManager();
//        System.out.println(ioManager.run());
        Calculation arithmeticCalculation = new ArithmeticCalculation();
        System.out.println(arithmeticCalculation.run("5 + 3 * 7+3 * 8"));
    }
}