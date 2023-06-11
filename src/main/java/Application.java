import io.Input;
import io.Output;
import repository.Repository;

public class Application {
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Repository repository = new MemoryResultRepository();
        new Calculator(input, output, repository).run();
    }
}
