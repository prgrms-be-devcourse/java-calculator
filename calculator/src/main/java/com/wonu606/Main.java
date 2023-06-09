package com.wonu606;

import com.wonu606.app.App;
import com.wonu606.calculator.CalculatorApp;
import com.wonu606.io.ConsolePrinter;
import com.wonu606.io.Input;
import com.wonu606.io.Print;
import com.wonu606.io.ConsoleInput;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Print printer = new ConsolePrinter();

        CalculatorApp app = new CalculatorApp();
        try {
            runApp(app, input, printer);
        } catch (Exception exception) {
            printer.print(exception.getMessage());
        } finally {
            input.tearDown();
            printer.tearDown();
        }
    }

    private static void runApp(App app, Input input, Print printer) throws IOException {
        app.execute(input, printer);
    }
}
