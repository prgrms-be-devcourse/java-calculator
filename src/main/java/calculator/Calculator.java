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

    public int execute(String exp) {
        int answer = 0;
        exp = exp.replaceAll("\s", "");
        try {
            ArrayList<String> postfix = parser.parse(exp);
            answer = calculate.execute(postfix);
            repository.save(exp, answer);
            out.answerPrint(answer);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return answer;
    }

    public void history() {
        repository.historyPrint(out);
    }
}
