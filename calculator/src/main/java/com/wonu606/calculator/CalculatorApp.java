package com.wonu606.calculator;

import com.wonu606.app.App;
import com.wonu606.io.Input;
import com.wonu606.io.Print;
import java.io.IOException;

public class CalculatorApp implements App {

    Input input;
    Print printer;

    public void execute(Input input, Print printer) throws IOException {
        this.input = input;
        this.printer = printer;

        while (true) {
            String selection = input.getInput();
        }
    }
}
