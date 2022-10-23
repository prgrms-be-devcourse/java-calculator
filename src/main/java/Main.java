import engine.calculator.Calculator;
import engine.io.ConsoleInput;
import engine.io.ConsoleOutput;

public class Main {
    public static void main(String[] args) {

        new Calculator(new ConsoleInput(), new ConsoleOutput()).run();
    }
}
