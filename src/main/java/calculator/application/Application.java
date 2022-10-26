package calculator.application;

import calculator.application.io.Console;
import calculator.engine.controller.Calculator;
import calculator.engine.controller.Controller;
import calculator.engine.repository.CalculationHistory;
import calculator.engine.repository.History;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Console console = new Console();
        History history = new CalculationHistory();
        Controller controller = new Controller(calculator, console, console, history);

        Thread CalculatorApplication = new Thread(controller);
        CalculatorApplication.start();
        CalculatorApplication.interrupt();
    }
}
