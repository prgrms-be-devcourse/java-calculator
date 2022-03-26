package calculator;

import calculator.repository.MemoryResultRepository;
import calculator.repository.ResultRepository;
import calculator.view.Console;

public class Application {
    public static void main(String[] args) {
        ResultRepository repository = new MemoryResultRepository();
        Console console = new Console();

        Calculator calculator = new Calculator(repository, console, console);
        calculator.run();
    }
}
