import engine.calculator.Calculator;
import engine.compute.Computer;
import engine.compute.validator.SimpleExpressionValidator;
import engine.history.MapHistory;
import engine.io.ConsoleInput;
import engine.io.ConsoleOutput;
import engine.operate.ExpressionFactory;

public class Main {
    public static void main(String[] args) {
        new Calculator(new ConsoleInput(),
                new ConsoleOutput(),
                new MapHistory(),
                new Computer(
                        new SimpleExpressionValidator(),
                        new ExpressionFactory(new SimpleExpressionValidator())
                )
        )
                .run();

    }
}
