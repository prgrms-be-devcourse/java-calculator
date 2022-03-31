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

import java.util.ArrayList;

public class Calculator {
    Input input;
    Output out;
    Parser parser;
    Calculate calculate;
    ExpressRepository repository;

    public Calculator(Input input, Output out, Parser parser, Calculate calculate, ExpressRepository repository) {
        this.input = input;
        this.out = out;
        this.parser = parser;
        this.calculate = calculate;
        this.repository = repository;
    }

    public void execute(String exp) {
        ArrayList<String> postfix = parser.parse(exp);
        int answer = calculate.execute(postfix);
        repository.save(exp, answer);
        out.answerPrint(answer);
    }

    public void history() {
        repository.historyPrint(out);
    }
}
