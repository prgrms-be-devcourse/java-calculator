package calculator;

import calculator.io.Input;
import calculator.io.Output;

public class Application {
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        new Calculator(input, output).run();
    }
}
