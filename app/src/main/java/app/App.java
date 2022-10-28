package app;

import app.calculator.BasicPostfixMaker;
import app.calculator.Calculator;
import app.calculator.PostfixMaker;
import app.io.Console;
import app.storage.MapStorage;
import app.storage.Storage;
import app.validator.InputValidator;

public class App {

    public static void main(String[] args) {

        Console console = new Console();
        Storage storage = new MapStorage();
        PostfixMaker postfixMaker = new BasicPostfixMaker();
        InputValidator inputValidator = new InputValidator();
        new Calculator(console , console, storage, postfixMaker, inputValidator).run();
    }
}
