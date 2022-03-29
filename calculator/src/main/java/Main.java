import io.Input;
import io.Output;
import repository.InMemoryRepository;
import repository.Repository;
import service.Calculator;
import service.Console;
import service.Validator;

public class Main {
    public static void main(String[] args) {
        Repository calculatorRepository = new InMemoryRepository();
        Input input = new Input();
        Output output = new Output();
        Validator validator = new Validator();
        Calculator calculator = new Calculator(calculatorRepository, input, output, validator);
        new Console(input, calculator).run();
    }
}