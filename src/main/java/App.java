import controller.CalculatorApplication;
import model.calculator.Calculator;
import model.calculator.CalculatorImpl;
import repository.CalculationLogRepository;
import repository.CalculationLogRepositoryImpl;

import static view.OutputView.*;

public class App {
    public static void main(String[] args) {
        Calculator calculator =  new CalculatorImpl();
        CalculationLogRepository repository =  new CalculationLogRepositoryImpl();
        CalculatorApplication app = new CalculatorApplication(calculator, repository);
        try {
            app.run();
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
        }
    }
}
