package calculator.controller;

import calculator.filter.Filter;
import calculator.io.Console;
import calculator.model.History;
import calculator.operator.Operator;
import lombok.AllArgsConstructor;

import java.util.Stack;

@AllArgsConstructor
public class Calculator implements Runnable {

    private final static int LIST = 1;
    private final static int CALCULATION = 2;
    private final static int EXIT = 3;

    private final Console input;
    private final Console output;
    private final History history;
    private final Operator operation;
    private final Filter filter;


    @Override
    public void run() {

        int selectNumber = 0;
        do {
            output.startMenu();
            String s = input.input();
            selectNumber = filter.isSelect(s);

            switch (selectNumber) {
                case LIST:
                    history.historyList();
                    break;

                case CALCULATION:
                    String line = input.input();
                    String clearLine = filter.clearSpace(line);

                    if (!filter.validate(clearLine)) continue;
                    if (history.isContainsKey(clearLine)) continue;

                    Stack<String> expression = filter.changeStringToStack(clearLine);

                    // 곱셈, 나눗셈 연산을 하는지 검사 후 연산
                    if (operation.isMultiplyOrDivide(clearLine)) expression = operation.multiplyOrDivide(expression);
                    // 덧셈, 뺄셈 연산
                    double calculateResult = operation.addOrSubtract(expression);

                    // 결과값이 double 타입인 경우 최대 소수 10번째자리까지 보이도록 format
                    String value = filter.formatResult(calculateResult);
                    // map 저장을 위한 key 매핑
                    String key = filter.keyMapping(clearLine);
                    history.addHistory(key, value);
                    history.getHistory(key);
                    break;

                case EXIT:
                    output.exit();
                    return;
                default:
                    output.inputError();
            }
        } while (selectNumber != 3) ;
    }
}

