import engine.calculator.Calculator;
import engine.compute.Computer;
import engine.compute.validator.SimpleExpressionValidator;
import engine.history.MapHistory;
import engine.io.ConsoleInput;
import engine.io.ConsoleOutput;
import engine.compute.converter.ExpressionConverter;

public class Main {
    public static void main(String[] args) {
        new Calculator(new ConsoleInput(),
                new ConsoleOutput(),
                new MapHistory(),
                new Computer(
                        new SimpleExpressionValidator(),
                        new ExpressionConverter(new SimpleExpressionValidator())
                )
        )
                .run();

    }
}
