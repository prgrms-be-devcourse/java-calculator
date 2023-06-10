package example.calculator;

import example.calculator.model.Calculator;
import example.calculator.view.Output;
import example.calculator.view.Input;

public class CalculatorController {
    private Input input;
    private Output output;
    private Calculator calculator;

    public CalculatorController(Input input, Output output, Calculator calculator) {
        this.input = input;
        this.output = output;
        this.calculator = calculator;
    }

    public void start() {
        while (true) {
            output.printMenu();
            int choice = input.getIntInput();

            switch (choice) {
                case 1:
                    output.printCalculationHistory(calculator.getCalculationHistory());
                    break;
                case 2:
                    handleCalculation();
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }

    private void handleCalculation() {
        input.getStringInput();

        System.out.print("수식을 입력하세요: ");
        String expression = input.getStringInput();

        String[] tokens = expression.split("\\s+");
        double result = calculator.handleCalculation(tokens, expression);

        output.printResult(result);
    }
}
