package example;

import example.calculator.CalculatorController;
import example.calculator.model.Calculator;
import example.calculator.view.Input;
import example.calculator.view.Output;

public class Main {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(new Input(), new Output(),
                new Calculator());
        calculatorController.start();
    }
}
