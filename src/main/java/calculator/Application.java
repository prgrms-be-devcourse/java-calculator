package calculator;

import calculator.handler.ICalculateHandler;
import calculator.handler.ILookupHandler;
import calculator.io.Input;
import calculator.io.Output;
import calculator.respository.Repository;

public class Application {
    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();

        Repository repository = new MemoryResultRepository();

        ILookupHandler lookupHandler = new LookupHandler(repository);
        ICalculateHandler calculateHandler = new CalculateHandler(repository);

        new Calculator(input, output, lookupHandler, calculateHandler).run();
    }

}
