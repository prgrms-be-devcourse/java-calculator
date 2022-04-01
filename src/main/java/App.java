import engine.Calculator;
import engine.io.Input;
import engine.io.Output;
import engine.model.Record;
import utility.Console;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        Record record = new Record();

        new Calculator(console, record).run();
    }
}
