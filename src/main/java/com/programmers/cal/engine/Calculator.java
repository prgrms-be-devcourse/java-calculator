package com.programmers.cal.engine;

import com.programmers.cal.engine.io.Input;
import com.programmers.cal.engine.io.Output;
import com.programmers.cal.engine.operation.Operation;
import com.programmers.cal.engine.parse.Parse;
import com.programmers.cal.engine.postfix.Postfix;
import com.programmers.cal.engine.repository.Repository;
import com.programmers.cal.engine.validator.Validator;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Calculator implements Runnable {

    private static final String PRINT_RECORD = "1";
    private static final String CALCULATE = "2";
    private static final String EXIT = "3";

    private Input input;
    private Output output;
    private Validator validator;
    private Parse parse;
    private Postfix postfix;
    private Operation operation;
    private Repository repository;

    @Builder
    public Calculator(Input input, Output output, Validator validator, Parse parse,
             Postfix postfix, Operation operation, Repository repository) {
        this.input = input;
        this.output = output;
        this.validator = validator;
        this.parse = parse;
        this.postfix = postfix;
        this.operation = operation;
        this.repository = repository;
    }

    @Override
    public void run() {

        while (true) {
            output.requestInput();
            String inputString = input.inputOrder();

            switch (inputString) {
                case PRINT_RECORD:
                    printRecord();
                    break;
                case CALCULATE:
                    calculate();
                    break;
                case EXIT:
                    exit();
                    return;
                default:
                    output.printWrongOrder();
            }
        }
    }

    private void printRecord() {
        List<String> recordList = repository.findAll();

        if(recordList.isEmpty()){
            output.printNoRecord();
        }else{
            output.printRecord(recordList);
        }
    }

    private void calculate() {
        String inputString = input.inputOrder();

        if(!validator.isExpression(inputString)){
            output.printWrongOrder();
            return;
        }

        List<String> tokens = parse.getTokenList(inputString);

        try {
            List<String> postfixTokens = postfix.toPostfix(tokens);
            String result = operation.calculate(postfixTokens);

            repository.save(inputString, result);

            output.printResult(result);
        } catch(Exception e) {
            output.printZeroDivision();
        }
    }

    private void exit() {
        output.printExit();
    }
}
