package com.programmers.calculator.engine;

import com.programmers.calculator.engine.calculation.Calculate;
import com.programmers.calculator.engine.conversion.Conversion;
import com.programmers.calculator.engine.io.Input;
import com.programmers.calculator.engine.io.Output;
import com.programmers.calculator.engine.menu.Menu;
import com.programmers.calculator.engine.storage.Storage;

import java.util.List;

public class Calculator implements Runnable {
    private Input input;
    private Output output;
    private Conversion conversion;

    private Calculate calculate;
    private Storage storage;


    private final String MENU_PROMPT = "1.조회 \n2.계산 \n3.종료 \n\n선택 : ";
    private final String CALCULATION_PROMT = "숫자, (, ), +, -, *, / 사용 가능 \n수식 : ";

    public Calculator(Input input, Output output, Conversion conversion, Calculate calculate, Storage storage) {
        this.input = input;
        this.output = output;
        this.conversion = conversion;
        this.calculate = calculate;
        this.storage = storage;
    }


    @Override
    public void run() {
        while (true) {
            String userInputMenu = Menu.chooseMenu(input.menuInput(MENU_PROMPT));

            if (userInputMenu.equals("3")) {
                output.endNotification();
                break;
            }

            if (userInputMenu.equals(Menu.CALCULATION.toString())) {
                String formula = input.formulaInput(CALCULATION_PROMT);
                List<String> postfix = conversion.formulaToPostfixTokens(formula);

                String result = formula + " = " + calculate.calculate(postfix);
                storage.save(result);

                System.out.println("결과 : " + result + "\n");


                //if else 없이 Symbol 에서 잘 처리해주면 된다고 생각하는데 잘 모르겠습니다.
            } else if (userInputMenu.equals(Menu.LOOKUP.toString())) {
                storage.findAll();
            }


        }
    }


}
