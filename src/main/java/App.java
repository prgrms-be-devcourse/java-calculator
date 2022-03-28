import engine.Calculator;
import engine.model.Function;
import engine.model.Record;

public class App {
    public static void main(String[] args) {
        new Calculator(new Console(), new Console(), new Function(), new Record()).run();
    }
}
