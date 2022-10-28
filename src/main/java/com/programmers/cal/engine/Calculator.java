package com.programmers.cal.engine;

import com.programmers.cal.engine.io.Input;
import com.programmers.cal.engine.io.Output;
import com.programmers.cal.engine.model.*;
import com.programmers.cal.engine.operation.Operation;
import com.programmers.cal.engine.parse.Parser;
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
    private Parser parser;
    private Postfix postfix;
    private Operation operation;
    private Repository repository;

    private InputData inputData = new InputData();
    private Equation equation = new Equation();

    @Builder
    public Calculator(Input input, Output output, Validator validator, Parser parser,
                      Postfix postfix, Operation operation, Repository repository) {
        this.input = input;
        this.output = output;
        this.validator = validator;
        this.parser = parser;
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
                    printRecordProcess();
                    break;
                case CALCULATE:
                    calculateProcess();
                    break;
                case EXIT:
                    exitProcess();
                    return;
                default:
                    output.printWrongOrder();
            }
        }
    }

    private void printRecordProcess() {
        Record record = repository.findAll();

        if (record.isEmpty(record)) {
            output.printNoRecord();
        } else {
            output.printRecord(record);
        }
    }

    private void calculateProcess() {

        inputData = inputData.toInputData(input.inputOrder());

        if (!validator.isExpression(inputData)) {
            output.printWrongOrder();
            return;
        }

        OriginalExpression originalTokens = parser.getTokenList(inputData);

        try {
            PostfixExpression postfixTokens = postfix.toPostfix(originalTokens);
            Answer answer = operation.calculate(postfixTokens);
            equation = equation.toEquation(inputData, answer);

            repository.save(equation);
            output.printResult(answer);
        } catch (Exception e) {
            output.printZeroDivision();
        }
    }

    private void exitProcess() {
        output.printExit();
    }

}
