package com.programmers.calculator.engine;

import com.programmers.calculator.engine.calculation.Symbol;
import com.programmers.calculator.engine.conversion.Conversion;
import com.programmers.calculator.engine.io.Input;
import com.programmers.calculator.engine.io.Output;
import com.programmers.calculator.engine.menu.Menu;

import java.util.List;

public class Calculator implements Runnable {
    private Input input;
    private Output output;
    private Conversion conversion;
    private final String MENU_PROMPT = "1.조회 \n2.계산 \n3.종료 \n\n선택 : ";
    private final String CALCULATION_PROMT = "숫자, (, ), +, -, *, / 사용 가능 \n수식 : ";

    public Calculator(Input input, Output output, Conversion conversion) {
        this.input = input;
        this.output = output;
        this.conversion = conversion;
    }


    double calculate(double a, String symbol, double b) {
        return Symbol.calculate(symbol, a, b);
    }


    @Override
    public void run() {
        while (true) {
            String userInputMenu = Menu.chooseMenu(input.menuInput(MENU_PROMPT));

            if (userInputMenu.equals("3")) {
                output.endNotification();
                break;
            }

            if (userInputMenu == Menu.CALCULATION.toString()) {
                String formula = input.formulaInput(CALCULATION_PROMT);
                List<String> postfix = conversion.formulaToPostfixTokens(formula);



            } else if (userInputMenu.equals("2")) System.out.println("조회 실행");


        }
    }


}
