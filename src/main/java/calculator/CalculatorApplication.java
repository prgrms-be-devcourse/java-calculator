package calculator;

import calculator.controller.CalculatorController;
import calculator.domain.repository.CalculatorRepository;
import calculator.service.CalculatorProcessor;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorApplication {
    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(getInputViewInstance(), getOutViewInstance(), getCalculatorServiceInstance());
        calculatorController.run();
    }

    private static InputView getInputViewInstance() {
        return new InputView();
    }

    private static OutputView getOutViewInstance() {
        return new OutputView();
    }

    private static CalculatorService getCalculatorServiceInstance() {
        return new CalculatorService(getCalculatorProcessorInstance(), getCalculatorRepositoryInstance());
    }

    private static CalculatorRepository getCalculatorRepositoryInstance() {
        return new CalculatorRepository();
    }

    private static CalculatorProcessor getCalculatorProcessorInstance() {
        return new CalculatorProcessor();
    }
}
