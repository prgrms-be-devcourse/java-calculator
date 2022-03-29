import io.Console;
import io.Input;
import io.Output;
import repository.CalculatorMemoryRepository;
import repository.CalculatorRepository;
import service.CalculatorService;
import validation.Validate;
import validation.ValidateService;

public class AppConfig {
    public Input input(){
        return new Console();
    }

    public Output output(){
        return new Console();
    }

    public CalculatorRepository calculatorRepository(){
        return new CalculatorMemoryRepository();
    }

    public CalculatorService calculationService(){
        return new CalculatorService(
                calculatorRepository()
        );
    }

    public Validate validate(){
        return new ValidateService();
    }

}
