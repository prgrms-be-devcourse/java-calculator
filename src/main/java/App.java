import engine.Calculator;
import engine.model.Function;

public class App {
    public static void main(String[] args) {
        new Calculator(new Console(), new Function()).run();
    }
}
