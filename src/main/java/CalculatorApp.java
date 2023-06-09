import calculator.Calculator;
import calculator.InfixToPostfixConvertorImpl;
import calculator.repository.CalculationRepository;

public class CalculatorApp {
    public static void main(String[] args) {
        Console console = new Console();
        InfixToPostfixConvertorImpl infixToPostfixConvertor = new InfixToPostfixConvertorImpl();
        CalculationRepository repository = new CalculationRepository();

        new Calculator(infixToPostfixConvertor, console, console, repository).run();


    }
}
