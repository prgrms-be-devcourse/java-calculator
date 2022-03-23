package com.programmers.java.calculation;


import com.programmers.java.calculation.repository.RepositoryImpl;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        CalculationService calculationService = new CalculationService(console, console, new RepositoryImpl());

        calculationService.run();


    }
}
