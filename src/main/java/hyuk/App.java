package hyuk;

import hyuk.calculator.Calculator;
import hyuk.controller.CalculatorController;
import hyuk.repository.MemoryRepository;
import hyuk.view.ConsoleInputView;
import hyuk.view.ConsoleOutputView;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        new CalculatorController(
            new ConsoleInputView(new Scanner(System.in)),
            new ConsoleOutputView(),
            new Calculator(),
            new MemoryRepository())
            .run();
    }
}
