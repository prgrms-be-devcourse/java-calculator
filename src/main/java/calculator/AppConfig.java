package calculator;

import calculator.calculate.Calculate;
import calculator.calculate.PostfixCalculate;
import calculator.io.Console;
import calculator.io.Input;
import calculator.io.Output;
import calculator.parse.Parser;
import calculator.parse.StackParser;
import calculator.repository.ExpressRepository;
import calculator.repository.MemoryExpressRepository;

public class AppConfig {

    public ExpressRepository expressRepository() {
        return new MemoryExpressRepository();
    }

    public Input input() {
        return new Console();
    }

    public Output output() {
        return new Console();
    }

    public Parser parser() {
        return new StackParser();
    }

    public Calculate calculate() {
        return new PostfixCalculate();
    }
}
