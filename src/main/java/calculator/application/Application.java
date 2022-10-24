package calculator.application;

import calculator.engine.controller.Calculator;
import calculator.engine.controller.Controller;
import calculator.application.io.Console;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Console console = new Console();
        Controller controller = new Controller(calculator, console, console);

        Thread CalculatorApplication = new Thread(controller);
        CalculatorApplication.start();
        CalculatorApplication.interrupt();
    }
}
