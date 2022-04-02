import io.Input;
import io.Output;
import service.CalculatorService;
import validation.ValidateService;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        Input input = appConfig.input();
        Output output = appConfig.output();
        CalculatorService calculatorService = appConfig.calculationService();
        ValidateService validateService = appConfig.validateService();

        Calculator calculator = new Calculator(input, output, calculatorService, validateService);
        calculator.run();
    }
}
