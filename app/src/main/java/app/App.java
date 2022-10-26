package app;

import app.calculator.BasicPostfixMaker;
import app.calculator.Calculator;
import app.io.Console;
import app.storage.MapStorage;
import app.validator.InputValidator;

public class App {

    public static void main(String[] args) {
        new Calculator(new Console(), new Console(), new MapStorage(), new BasicPostfixMaker(),new InputValidator()).run();
    }
}
