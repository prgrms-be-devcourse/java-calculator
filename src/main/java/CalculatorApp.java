import calculator.Calculator;
import calculator.InfixToPostfixConverter;
import calculator.repository.CalculationRepository;

public class CalculatorApp {
    public static void main(String[] args) {
        CalculatorConsole console = new CalculatorConsole();
        InfixToPostfixConverter infixToPostfixConvertor = new InfixToPostfixConverter();
        CalculationRepository repository = new CalculationRepository();

        new Calculator(infixToPostfixConvertor, console, console, repository).run();


    }
}
