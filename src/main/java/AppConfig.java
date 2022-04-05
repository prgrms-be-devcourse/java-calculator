import engine.Calculator;
import engine.repository.CalculatorRepository;

public class AppConfig {

    public Calculator calculator() {
        return new Calculator(calculatorRepository(),console(),console());
    }

    public Console console() {
        return new Console();
    }

    public CalculatorRepository calculatorRepository(){
        return new CalculatorRepository();
    }
}
