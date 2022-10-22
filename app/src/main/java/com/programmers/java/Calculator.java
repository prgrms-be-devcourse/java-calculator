package com.programmers.java;

import com.programmers.java.io.Screen;
import com.programmers.java.repository.Repository;

public class Calculator implements Runnable {
    private final Screen screen;
    private final Repository repository;
    private final FormulaParser parser;
    private final String MENU = "1. 조회\n2. 계산\n\n선택 : ";

    public Calculator(Screen screen, Repository repository, FormulaParser parser) {
        this.screen = screen;
        this.repository = repository;
        this.parser = parser;
    }

    @Override
    public void run() {
        while (true) {
            screen.printMenu(MENU);
            int chosenNumber = screen.inputMenuNumber();

            switch (chosenNumber) {
                case 1:
                    screen.printHistory(repository.findAllHistory());
                    break;
                case 2:
                    String formula = screen.inputFormula();
                    String parsedFormula = parser.changeInfixToPostfix(formula);
                    // 계산
                    // 저장
                    // 출력
                    break;
                default:
                    return;
            }
        }
    }
}
