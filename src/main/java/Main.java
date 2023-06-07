import calculator.controller.CalculatorController;
import calculator.domain.Calculator;
import calculator.service.CalculatorService;
import ui.InputView;
import ui.OutputView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController(
                  inputViewInstance()
                , outputViewInstance()
                , calculatorServiceInstance());

        controller.start();
    }

    private static InputView inputViewInstance() {
        return new InputView(scannerInstance());
    }
    private static Scanner scannerInstance() {
        return new Scanner(System.in);
    }

    private static OutputView outputViewInstance() {
        return new OutputView();
    }

    private static CalculatorService calculatorServiceInstance() {return new CalculatorService();}
}
