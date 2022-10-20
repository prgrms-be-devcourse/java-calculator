package com.programmers.java;

import com.programmers.java.io.Screen;
import com.programmers.java.repository.Repository;

public class Calculator implements Runnable {
    private final Screen screen;
    private final Repository repository;
    private final String MENU = "1. 조회\n2. 계산\n\n선택 : ";

    public Calculator(Screen screen, Repository repository) {
        this.screen = screen;
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true) {
            screen.printMenu(MENU);
            int chosenNumber = screen.inputMenuNumber();

            switch (chosenNumber) {
                case 1:
                    // 조회 로직
                    break;
                case 2:
                    String formula = screen.inputFormula();
                    // 계산 로직
                    break;
                default:
                    return;
            }
        }
    }
}
