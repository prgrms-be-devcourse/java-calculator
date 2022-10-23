package com.project.java.engine;

import com.project.java.engine.io.Input;
import com.project.java.engine.io.Output;
import com.project.java.engine.repository.Repository;
import com.project.java.engine.solver.Solver;
import com.project.java.exception.ZeroDivisionException;
import lombok.AllArgsConstructor;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
public class Calculator {
    private static final String MESSAGE = "번호를 입력해주세요 : ";
    private static final String MESSAGE_EXPRESSION = "계산식을 입력해주세요 : ";
    private Input input;
    private Output output;
    private Solver solver;
    private Repository repository;

    public void run() throws IOException {

        while(true) {
            String cmd = input.getInput(MESSAGE);
            switch(cmd) {
                case "1":
                    List<String> historyList = repository.findAll();
                    if(historyList.size() ==0) {
                        output.messageEmpty();
                    } else {
                        output.printHistory(historyList);
                    }
                    break;
                case "2":
                    String expression = input.getExpression(MESSAGE_EXPRESSION);
                    if (!input.validateInput(expression)) {
                        output.inputError();
                        continue;
                    }
                    Map<Integer, List<String>> resultMap;
                    try {
                        resultMap = solver.calculate(expression);
                    } catch (ZeroDivisionException e) {
                        output.inputError();
                        continue;
                    }
                    Integer result = resultMap.keySet().stream().toArray(Integer[]::new)[0];
                    output.printResult(String.valueOf(result));
                    repository.save(resultMap);
                    break;
                default:
                    output.inputError();
            }
        }
    }
}
