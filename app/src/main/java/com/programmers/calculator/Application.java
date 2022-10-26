package com.programmers.calculator;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        appConfig.createController().run();
    }
}
