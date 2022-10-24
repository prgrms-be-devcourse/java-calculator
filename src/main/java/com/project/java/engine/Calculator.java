package com.project.java.engine;

import com.project.java.engine.io.Input;
import com.project.java.engine.io.Output;
import com.project.java.engine.repository.Repository;
import com.project.java.engine.solver.Solver;
import com.project.java.exception.ZeroDivisionException;
import com.project.java.utils.Command;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.project.java.utils.Command.*;

@AllArgsConstructor
public class Calculator {
    private static final String MESSAGE = "번호를 입력해주세요 : ";
    private static final String MESSAGE_EXPRESSION = "계산식을 입력해주세요 : ";
    private Input input;
    private Output output;
    private Solver solver;
    private Repository repository;

    public void run() throws IOException {

        while (true) {
            Command command = Command.valueOf(input.getInput(MESSAGE));

            switch (command) {
                case RETRIEVE -> {
                    retrieveAll();
                }
                case CALCULATE -> {
                    calculate();
                }
                case QUIT, ANOTHER_QUIT -> {return;}
                default -> output.inputError();
            }
        }
    }

    private void calculate() throws IOException {
        String expression = input.getExpression(MESSAGE_EXPRESSION);
        if (!input.validateInput(expression)) {
            output.inputError();
            return;
        }
        Map<String, Double> resultMap;
        try {
            resultMap = solver.calculate(expression);
        } catch (ZeroDivisionException e) {
            output.inputError();
            return;
        }
        String result = resultMap.keySet().stream().toList().get(0);
        String formattedResult = output.printResult(resultMap.get(result));
        repository.save(resultMap, formattedResult);
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
