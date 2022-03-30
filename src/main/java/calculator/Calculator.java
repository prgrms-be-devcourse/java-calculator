package calculator;

import calculator.io.Console;
import calculator.io.Input;
import calculator.parse.Parser;
import calculator.parse.StackParser;

public class Calculator {
    Input input = new Console();
    Parser parser = new StackParser();

    public void excute(String exp) {
        parser.parse(exp);
        // calculate
        // save
        // print
    }

    void historyPrint() {

    }
}
