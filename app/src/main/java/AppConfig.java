import repository.ResultRepository;
import service.CalculatorUIService;

public class AppConfig {

    public CalculatorUIService calculatorUIService() {
        return new CalculatorUIService();
    }

    private ResultRepository resultRepository() {
        return new ResultRepository();
    }
}
