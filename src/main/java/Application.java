import io.Input;
import io.Output;

public class Application {
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        new Calculator(input, output).run();
    }
}
