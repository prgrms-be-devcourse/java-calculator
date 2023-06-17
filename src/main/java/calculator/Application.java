package calculator;

import calculator.handler.ICalculateHandler;
import calculator.handler.ILookupHandler;
import calculator.io.Input;
import calculator.io.Output;

public class Application {
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        ICalculateHandler calculateHandler = new CalculateHandler();
        ILookupHandler lookupHandler = new LookupHandler();

        new Calculator(input, output, lookupHandler, calculateHandler).run();
    }

}
