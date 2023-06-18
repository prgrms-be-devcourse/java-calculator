package calculator;

import calculator.engine.Repository.Memorizer;
import calculator.engine.io.Input;
import calculator.engine.io.Output;
import calculator.engine.model.InitCalculator;
import calculator.engine.model.PostfixCalculator;
import java.util.List;
public class Calculator implements Runnable{
    private final Input input;
    private final Output output;
    private final Memorizer repository;
    private final InitCalculator initCalculator;
    private final PostfixCalculator postfixCalculator;
    public Calculator(Input input, Output output, Memorizer repository, InitCalculator initCalculator, PostfixCalculator postfixCalculator) {
        this.input = input;
        this.output = output;
        this.repository = repository;
        this.initCalculator = initCalculator;
        this.postfixCalculator = postfixCalculator;
    }
    public void run() {
        while (true) {
            output.consoleMenu();
            int command = input.selectConsoleNumber();

            switch (command) {
                case 1:
                    output.MemoryCalculator(repository.getMemoroizer());
                    break;
                case 2:
                    String expression = input.inputCalculator();
                    List<String> result = InitCalculator.calculate(expression);
                    int s = postfixCalculator.calculate(result);
                    output.printCalculator(s);
                    String restoreValue = expression + " = " + s;
                    repository.storeHistory(restoreValue);
                    break;
                default:
                    output.outputError();
                    break;
            }
        }
    }
}
