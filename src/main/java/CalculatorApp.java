import calculator.Calculator;
import calculator.CalculatorConsole;
import calculator.model.PostfixCalculator;
import calculator.util.converter.InfixToPostfixConverter;
import calculator.repository.CalculationRepository;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorConsole console = new CalculatorConsole();

        new Calculator(
                new PostfixCalculator(),
                new InfixToPostfixConverter(),
                console,
                console,
                new CalculationRepository()
        ).run();
    }
}
