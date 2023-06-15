package com.programmers.calculator;

import com.programmers.calculator.io.Input;
import com.programmers.calculator.io.Output;
import com.programmers.calculator.model.Expression;
import com.programmers.calculator.repository.HistoryRepository;

public class Calculator implements Runnable {
    private final int HISTORY = 1;
    private final int CALCULATE = 2;

    private HistoryRepository historyRepository;

    private Input input;
    private Output output;

    public Calculator() {
        Console console = new Console();
        this.input = console;
        this.output = console;
    }

    public Calculator(Input input, Output output, HistoryRepository historyRepository) {
        this.input = input;
        this.output = output;
        this.historyRepository = historyRepository;
    }

    @Override
    public void run() {
        while (true) {
            output.printMenu("1. 조회\n2. 계산\n");
            int menu = Integer.parseInt(input.inputMenu("선택 : ")); // 예외처리는 어떻게?

            switch (menu) {
                case HISTORY -> {
                    System.out.println("조회 실행");
                    // do more
                    historyRepository.printHistory();
                }

                case CALCULATE -> {
                    System.out.println("계산 실행");
                    // do more
                    Expression expression = input.inputExpression();
                    int result = expression.getResult();
                    System.out.println(result);
                    historyRepository.save(expression, result);
                }

                default -> System.out.println("잘못된 입력입니다.");

            }
        }
    }
}

