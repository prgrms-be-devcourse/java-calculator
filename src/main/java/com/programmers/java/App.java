package com.programmers.java;

import com.programmers.java.io.ConsoleService;
import com.programmers.java.logic.Calculator;
import com.programmers.java.repository.Repository;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Repository repository = new Repository();
        ConsoleService consoleService = new ConsoleService(calculator, repository);

        consoleService.run();
    }
}
