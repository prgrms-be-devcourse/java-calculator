package calulator;

import calulator.domain.Calculator;
import calulator.repository.InMemoryExpressionRepository;
import calulator.view.console.ConsoleInput;
import calulator.view.console.ConsoleOutput;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new ConsoleInput(), new ConsoleOutput(), new InMemoryExpressionRepository());

        calculator.run();
    }

}
