package com.programmers.java.calculator.application;

import com.programmers.java.calculator.io.Input;
import com.programmers.java.calculator.io.Output;
import com.programmers.java.calculator.repository.CalculatorRepository;
import com.programmers.java.calculator.utility.Operator;
import com.programmers.java.calculator.utility.PostfixConvertor;

import java.util.List;

public class Calculator {
    private final CalculatorRepository repository;
    private final Input input;
    private final Output output;
    private static final int HISTORY = 1, CALCULATE = 2;
    private final Operator operator;
    private final PostfixConvertor postfixConvertor;

    public Calculator(CalculatorRepository repository, Input input, Output output, Operator operator, PostfixConvertor postfixConvertor){
        this.repository = repository;
        this.input = input;
        this.output = output;
        this.operator = operator;
        this.postfixConvertor = postfixConvertor;
    }

    public void run(){
        int cmd = 0;
        while (cmd != -1) {
            cmd = input.inputCmd();

            switch (cmd) {
                case HISTORY:
                    List<String> history = repository.findAll();
                    output.outputHistory(history);
                    break;

                case CALCULATE:
                    String exp = input.inputExp();
                    double result = operator.calculate(exp);
                    repository.save(exp + " = " + result);
                    output.outputResult(result);
                    break;
            }
        }
    }
}
