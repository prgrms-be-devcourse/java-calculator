package com.programmers.contoller;

import com.programmers.calculator.Calculator;
import com.programmers.io.IOConsole;
import com.programmers.memory.HistoryMemory;

import java.io.IOException;

public class CalculatorController {
    // 계산기 옵션
    private static final String SHOW_HISTORY_OPTION = "1";
    private static final String CALCULATE_OPTION = "2";

    private static IOConsole ioConsole;
    private static Calculator calculator;
    private static HistoryMemory historyMemory;

    public CalculatorController() {
        ioConsole = new IOConsole(); // 입출력 콘솔
        calculator = new Calculator();  // 숫자 계산을 담당하는 부분
        historyMemory = new HistoryMemory(); // 계산 결과 메모리
    }

    public void run() throws IOException {
        while (true) {
            ioConsole.printMenu();

            String option = ioConsole.getOption();

            switch (option) {
                case SHOW_HISTORY_OPTION: {  // 1. 조회
                    String history = historyMemory.getHistory();
                    ioConsole.print(history);
                    break;
                }
                case CALCULATE_OPTION: {  // 2. 계산
                    String inputExpression = ioConsole.getInput();

                    if (!ioConsole.validateInputExpression(inputExpression)) {
                        break;
                    }

                    try {
                        String convertedExpression = calculator.convert(inputExpression);

                        double answer = calculator.calculate(convertedExpression);

                        historyMemory.saveHistory(inputExpression, answer);

                        ioConsole.printAnswer(answer);
                    } catch (Exception e) {
                        ioConsole.print(e.getMessage() + "\n");
                    }
                    break;
                }
                default: {  // 잘못된 입력을 처리
                    ioConsole.handleWrongInput();
                    return;
                }
            }
        }
    }
}
