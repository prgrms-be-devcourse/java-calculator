package com.project.java.engine;

import com.project.java.engine.data.ResultFormat;
import com.project.java.engine.io.Input;
import com.project.java.engine.io.Output;
import com.project.java.engine.repository.Repository;
import com.project.java.engine.solver.Solver;
import com.project.java.exception.ContinuousOperatorException;
import com.project.java.exception.ZeroDivisionException;
import com.project.java.utils.MenuSelectCommand;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;

import static com.project.java.utils.ConstantMessageUtil.MESSAGE;
import static com.project.java.utils.ConstantMessageUtil.MESSAGE_EXPRESSION;

@AllArgsConstructor
public class Calculator {

    private Input input;
    private Output output;
    private Solver solver;
    private Repository repository;

    public void run() throws IOException {

        while (true) {
            MenuSelectCommand command = MenuSelectCommand.valueOfCommand(input.getInput(MESSAGE));

            switch (command) {
                case RETRIEVE -> {
                    retrieveAll();
                }
                case CALCULATE -> {
                    String expression = input.getExpression(MESSAGE_EXPRESSION);
                    ResultFormat result = calculate(expression);
                    output.printResult(result);
                    repository.save(result);
                }
                case QUIT, ANOTHER_QUIT -> {return;}
                default -> output.inputError();
            }
        }
    }

    private ResultFormat calculate(String expression) throws IOException {

        if (!input.validateInput(expression)) {
            output.inputError();
            return makeInvalidResult(expression);
        }
        ResultFormat result;
        try {
            result = solver.calculate(expression);
        } catch (ZeroDivisionException | ContinuousOperatorException e) {
            output.inputError();
            return makeInvalidResult(expression);
        }
        return result;
    }

    private ResultFormat makeInvalidResult(String expression) {
        return new ResultFormat(expression, Long.MIN_VALUE);
    }

    private void retrieveAll() {
        List<String> historyList = repository.findAll();
        if (historyList.size() == 0) {
            output.messageEmpty();
        } else {
            output.printHistory(historyList);
        }
    }

}
