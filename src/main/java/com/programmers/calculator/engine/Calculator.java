package com.programmers.calculator.engine;

import com.programmers.calculator.engine.calculation.Symbol;
import com.programmers.calculator.engine.io.Input;
import com.programmers.calculator.engine.io.Output;
import com.programmers.calculator.engine.menu.Menu;
import com.programmers.calculator.utils.InputException;

public class Calculator implements Runnable {
    private Input input;
    private Output output;
    private final String MENU_PROMPT = "1.조회 \n2.계산 \n3.종료 \n\n선택 : ";

    public Calculator(Input input, Output output) {
        this.input = input;
        this.output = output;
    }


    double calculate(double a, String symbol, double b) {
        return Symbol.calculate(symbol, a, b);
    }


    @Override
    public void run() {
        while (true) {
            String userInputMenu = Menu.chooseMenu(input.menuInput(MENU_PROMPT));

            if (userInputMenu.equals("3")) {
                output.endNotification(); break;
            }

            if (userInputMenu.equals("1")) System.out.println("계산 실행");

            if (userInputMenu.equals("2")) System.out.println("조회 실행");


        }
    }


}
