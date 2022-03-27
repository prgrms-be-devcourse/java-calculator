import io.Input;
import io.InputImpl;
import io.Output;
import io.OutputImpl;
import repository.CalculatorRepository;
import repository.CalculatorRepositoryImpl;
import service.*;

public class Main {

    public static void main(String[] args) {
        Input input = new InputImpl();
        Output output = new OutputImpl();
        CalculatorRepository calculatorRepository = new CalculatorRepositoryImpl();
        Validator validator=new ValidatorImpl();
        CalculatorService calculatorService = new CalculatorServiceImpl(
                calculatorRepository, input, output,validator);
        new ServiceImpl(input, output, calculatorService).run();
    }
}
