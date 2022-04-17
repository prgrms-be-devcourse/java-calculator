import io.Console;
import io.Input;
import io.Output;
import repository.ResultRepository;

public class App {

    public static void main(String[] args) {
        ResultRepository resultRepository = new ResultRepository();
        Input input = new Console();
        Output output = new Console();
        new CalculatorApp(input, output, resultRepository).run();

    }
}
