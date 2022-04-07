package com.programmers.java;

public class MainApplication {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        Calculator calculator = appConfig.calculator();
        calculator.run();
    }
}
