package hyuk;

import hyuk.calculator.Calculator;
import hyuk.controller.CalculatorController;
import hyuk.repository.MemoryRepository;
import hyuk.service.CalculatorService;
import hyuk.view.ConsoleInputView;
import hyuk.view.ConsoleOutputView;

public class App {

    public static void main(String[] args) {
        new CalculatorController(
            new ConsoleInputView(),
            new ConsoleOutputView(),
            new CalculatorService(new MemoryRepository(), new Calculator()))
            .run();
    }
}
