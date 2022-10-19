package org.programmers.service;

import lombok.AllArgsConstructor;
import org.programmers.service.IO.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 변수 및 함수의 이름들을 보다 더 명확하게 수정해봤습니다.
 * 계산 결과값의 출력과 저장을 분리했습니다.
 */
@AllArgsConstructor
public class MainService implements Runnable {
    private final int ERROR_EXPRESSION_PATTERN = 1;
    private final int ERROR_DIVIDE_ZERO = 2;
    private final CalculateService calculateService;
    private final Console console;

    @Override
    public void run() {

        while (true) {
            console.printMenu();
            String inputNum = console.inputSelectMenu("선택 : ");

            if (inputNum.equals("1")) {
                console.historyInquiry(calculateService.findHistory());
            } else if (inputNum.equals("2")) {
                String expression = console.inputExpression();

                if (validCheck(expression) == ERROR_EXPRESSION_PATTERN) {
                    console.inputExError(ERROR_EXPRESSION_PATTERN);
                    continue;
                } else if (validCheck(expression) == ERROR_DIVIDE_ZERO) {
                    console.inputExError(ERROR_DIVIDE_ZERO);
                    continue;
                }

                double expressionResult = calculateService.calculateResult(expression);
                console.printResult(expressionResult);
                calculateService.historySave(expressionResult, expression);

            } else {
                console.inputNumError();
            }
        }
    }

    private int validCheck(String expression) {
        String pattern = "^-?(\\d*\\.?\\d+)([ \\t]+[-+/*][ \\t]+(\\d*\\.?\\d+))*";
        Pattern divZero = Pattern.compile("[/][ \\t]0((\\.0+)|$|[ \\t])");
        Matcher m = divZero.matcher(expression);

        if (!Pattern.matches(pattern, expression)){
            return ERROR_EXPRESSION_PATTERN;
        } else if (m.find()){
            return ERROR_DIVIDE_ZERO;
        }
        return 0;
    }
}
