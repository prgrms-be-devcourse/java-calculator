package org.example;

import org.example.domain.Calculator;
import org.example.domain.Console;
import org.example.view.View;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        Calculator calculator = new Calculator();

        new Console(view, calculator).run();

    }
}
