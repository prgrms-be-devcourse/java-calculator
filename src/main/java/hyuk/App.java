package hyuk;

import hyuk.controller.CalculatorController;
import hyuk.repository.MemoryRepository;
import hyuk.view.ConsoleInputView;
import hyuk.view.ConsoleOutputView;

public class App {

    public static void main(String[] args) {
        new CalculatorController(
            new ConsoleInputView(),
            new ConsoleOutputView(),
            new MemoryRepository())
            .run();
    }
}
