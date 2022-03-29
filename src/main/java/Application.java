import io.Input;
import io.Output;
import service.CalculatorService;
import validation.Validate;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        Input input = appConfig.input();
        Output output = appConfig.output();
        CalculatorService calculatorService = appConfig.calculationService();
        Validate validate = appConfig.validate();

        Calculator calculator = new Calculator(input,output, calculatorService, validate);
        calculator.run();
    }
}
