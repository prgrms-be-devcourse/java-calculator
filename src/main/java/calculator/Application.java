package calculator;

import calculator.engine.Repository.Memorizer;
import calculator.engine.model.InitCalculator;
import calculator.engine.model.PostfixCalculator;

public class Application {
    public static void main(String[] args) {
        Console console = new Console();
        Memorizer repository = new Memorizer();
        InitCalculator initCalculator = new InitCalculator();
        PostfixCalculator postfixCalculator = new PostfixCalculator();
        new Calculator(console,console,repository,initCalculator, postfixCalculator).run();
    }
}

