package com.programmers.java;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Repository repository = new Repository();
        ConsoleService consoleService = new ConsoleService(calculator, repository);

        consoleService.run();
    }
}
