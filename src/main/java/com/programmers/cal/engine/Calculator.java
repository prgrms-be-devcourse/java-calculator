package com.programmers.cal.engine;

import com.programmers.cal.engine.exit.Exit;
import com.programmers.cal.engine.io.Input;
import com.programmers.cal.engine.io.MenuType;
import com.programmers.cal.engine.io.Message;
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

@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Calculator {

    private Input input;
    private Output output;
    private Validator validator;
    private Parser parser;
    private Postfix postfix;
    private Operation operation;
    private Repository repository;
    private Exit exit;

    @Builder
    public Calculator(Input input, Output output, Validator validator, Parser parser,
                      Postfix postfix, Operation operation, Repository repository, Exit exit) {
        this.input = input;
        this.output = output;
        this.validator = validator;
        this.parser = parser;
        this.postfix = postfix;
        this.operation = operation;
        this.repository = repository;
        this.exit = exit;
    }

    public boolean run(MenuType menuType) {

        switch (menuType) {
            case PRINT_RECORD:
                printRecordProcess();
                break;
            case CALCULATE:
                calculateProcess();
                break;
            case EXIT:
                exitProcess();
                return false;
        }
        return true;
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

        InputData inputData = InputData.toInputData(input.inputOrder());

        if (!validator.isExpression(inputData)) {
            output.printWrongOrder();
            return;
        }

        OriginalExpression originalTokens = parser.getTokenList(inputData);

        try {
            PostfixExpression postfixTokens = postfix.toPostfix(originalTokens);
            Answer answer = operation.calculate(postfixTokens);
            Equation equation = Equation.toEquation(inputData, answer);

            repository.save(equation);
            output.printResult(answer);
        } catch (Exception e) {
            output.printZeroDivision();
        }
    }

    private void exitProcess() {
        Message exitMessage = exit.getExitMessage();
        output.printExit(exitMessage);
    }

}
