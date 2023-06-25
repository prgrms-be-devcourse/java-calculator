import calculator.controller.CalculatorController;
import calculator.repository.CalculatorRepository;
import calculator.service.CalculatorService;
import ui.InputView;
import ui.OutputView;

import java.util.Scanner;

public class CalculatorApplication {
    public static void main(String[] args) {
        CalculatorController controller = new CalculatorController(
                new InputView(scannerInstance())
                , new OutputView()
                , new CalculatorService(calculatorRepositoryInstance()));

        controller.start();
    }

    private static Scanner scannerInstance() {
        return new Scanner(System.in);
    }
    private static CalculatorRepository calculatorRepositoryInstance() {return new CalculatorRepository();}
}
