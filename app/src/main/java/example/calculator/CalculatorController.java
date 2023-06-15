package example.calculator;

import example.calculator.model.Calculator;
import example.calculator.view.Output;
import example.calculator.view.Input;

public class CalculatorController {
    private static final int MENU_VIEW_HISTORY = 1;
    private static final int MENU_HANDLE_CALCULATION = 2;
    private Input input;
    private Output output;
    private Calculator calculator;

    public CalculatorController(Input input, Output output, Calculator calculator) {
        this.input = input;
        this.output = output;
        this.calculator = calculator;
    }

    public void start() {
        boolean isRunning = true;

        while (isRunning) {
            output.printMenu();
            int userChoice = input.getIntInput();

            switch (userChoice) {
                case MENU_VIEW_HISTORY:
                    output.printCalculationHistory(calculator.getCalculationHistory());
                    break;
                case MENU_HANDLE_CALCULATION:
                    handleCalculation();
                    break;
                default:
                    isRunning = false;  // 루프 종료 조건
                    break;
            }
        }
    }

    private void handleCalculation() {
        input.getStringInput();

        output.printMessage();
        String expression = input.getStringInput();

        String[] tokens = expression.split("\\s+");
        double result = calculator.handleCalculation(tokens, expression);

        output.printResult(result);
    }
}
