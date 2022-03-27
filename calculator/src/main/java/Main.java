import repository.CalculatorRepository;
import repository.CalculatorRepositoryImpl;

public class Main {
    public static void main(String[] args) {
        CalculatorRepository repository = new CalculatorRepositoryImpl();
        new Calculator().run();
    }
}
