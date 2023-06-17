import computation.PostfixComputer;
import computation.PostfixConverter;
import io.Calculator;
import repository.CalculatorHistoryRepository;

import java.io.IOException;

public class CalculatorApplication {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator(new PostfixConverter(), new PostfixComputer(), new CalculatorHistoryRepository());
        calculator.runApplication();
    }
}
