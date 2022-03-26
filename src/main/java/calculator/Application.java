package calculator;

import calculator.repository.MemoryResultRepository;
import calculator.repository.ResultRepository;
import calculator.utils.ExpressionParser;
import calculator.utils.Parser;
import calculator.view.Console;

public class Application {
    public static void main(String[] args) {
        Parser parser = new ExpressionParser();
        ResultRepository repository = new MemoryResultRepository();
        Console console = new Console();

        Calculator calculator = new Calculator(repository, parser, console, console);
        calculator.run();
    }
}
