package com.programmers.kwonjoosung.java.calculator;

import com.programmers.kwonjoosung.java.calculator.io.Console;
import com.programmers.kwonjoosung.java.calculator.repository.MemoryCalculationRepository;
import com.programmers.kwonjoosung.java.calculator.service.ArithmeticCalculator;

public class App {
    public static void main(String[] args) {
        build().run();
    }

    private static Calculator build() {
        return new Calculator(
                    new ArithmeticCalculator(),
                    new Console(),
                    new MemoryCalculationRepository());
    }
}
