import controller.CalculatorApplication;
import model.service.CalculateService;
import model.service.CalculateServiceImpl;
import repository.CalculationLogRepository;
import repository.CalculationLogRepositoryImpl;

import static view.OutputView.*;

public class App {
    public static void main(String[] args) {
        CalculateService calculateService =  new CalculateServiceImpl();
        CalculationLogRepository repository =  new CalculationLogRepositoryImpl();
        CalculatorApplication app = new CalculatorApplication(calculateService, repository);
        try {
            app.run();
        } catch (Exception e) {
            printErrorMessage(e.getMessage());
        }
    }
}
