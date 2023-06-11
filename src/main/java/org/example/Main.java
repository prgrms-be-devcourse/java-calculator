package org.example;

import org.example.domain.Calculator;
import org.example.domain.Console;
import org.example.view.InputView;
import org.example.view.OutputView;

public class Main {

    public static void main(String[] args) {

        Console console = new Console(new InputView(), new OutputView(), new Calculator());
        console.run();

    }
}
