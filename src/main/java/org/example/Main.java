package org.example;

import org.example.domain.Calculator;
import org.example.domain.Console;
import org.example.repository.Records;
import org.example.view.View;

public class Main {

    public static void main(String[] args) {
        View view = new View();
        Calculator calculator = new Calculator();
        Records records = new Records();

        new Console(view, calculator, records).run();

    }
}
