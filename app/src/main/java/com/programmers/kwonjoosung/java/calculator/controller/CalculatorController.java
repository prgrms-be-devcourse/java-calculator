package com.programmers.kwonjoosung.java.calculator.controller;

import com.programmers.kwonjoosung.java.calculator.io.Input;
import com.programmers.kwonjoosung.java.calculator.io.Output;
import com.programmers.kwonjoosung.java.calculator.repository.Cache;
import com.programmers.kwonjoosung.java.calculator.repository.Repository;
import com.programmers.kwonjoosung.java.calculator.service.Calculator;
import com.programmers.kwonjoosung.java.calculator.utils.Parser;
import lombok.Builder;

import java.util.Optional;

@Builder
public class CalculatorController {
    // Dependency
    private final Repository HISTORY;
    private final Cache CACHE;
    private final Calculator CALCULATOR;
    private final Parser parser;
    private final Input IN;
    private final Output OUT;

    // MENU BUTTONS
    private static final int LOOKUP = 1;
    private static final int CALCULATE = 2;
    private static final int EXIT = 99;
    private static int calculateCount = 0;

    public void run() { // 계산기 메인 프로세스
        app:
        while (true) {
            try {
                OUT.printMenu();
                switch (IN.inputMenu()) {
                    case LOOKUP:
                        showHistory();
                        break;
                    case CALCULATE: // 식 받아와서 계산하고 출력
                        String[] expression = parser.parsing(IN.inputExpression());
                        String result = calculate(expression);
                        OUT.println(result);
                        break;
                    case EXIT:
                        OUT.printExit();
                        break app;
                    default:
                        OUT.printMenuError();
                }
                IN.inputNext(); // 계속하려면 아무키나 입력하세요..
            } catch (Exception e) { // 예외 상황에 대한 처리를 한번에 해도 되는가?
                OUT.printError(e.getMessage());
            }
        }
    }

    private String calculate(String[] expression) { // 계산로직: 캐시 체크 -> 없으면 계산 or 있으면 값 사용 -> 식, 결과 저장 ->  값 반환
        Optional<String> data = CACHE.getResult(expression);
        String result = data.orElseGet(() -> CALCULATOR.calculate(expression));
        CACHE.add(expression, result);
        HISTORY.save(expression, result);
        calculateCount++;
        return result;
    }

    private void showHistory() { // 데이터가 없으면 에러 / 있으면 값 출력
        if (calculateCount == 0) OUT.printNullError();
        for (int i = 0; i < calculateCount; i++)
            HISTORY.getHistory(i).ifPresent(OUT::println);
    }
}
