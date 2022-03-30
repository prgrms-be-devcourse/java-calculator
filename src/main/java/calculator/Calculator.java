package calculator;

import calculator.calculate.Calculate;
import calculator.calculate.PostfixCalculate;
import calculator.io.Console;
import calculator.io.Input;
import calculator.parse.Parser;
import calculator.parse.StackParser;

import java.util.ArrayList;
import java.util.Stack;

public class Calculator {
    Input input = new Console();
    Parser parser = new StackParser();
    Calculate calculate = new PostfixCalculate();

    public void execute(String exp) {
        ArrayList<String> postfix = parser.parse(exp);
        int answer = calculate.execute(postfix);
        // save
        // print
    }



    void historyPrint() {

    }
}
