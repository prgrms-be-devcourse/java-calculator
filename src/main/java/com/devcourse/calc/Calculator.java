package com.devcourse.calc;

import com.devcourse.calc.model.Menu;
import com.devcourse.view.Input;
import com.devcourse.view.Output;

public class Calculator {

    public void run() {
        int menu = selectMenu();
        Output.viewResult(Menu.doAction(menu, this));
    }

    public String showHistory() {
        return "계산 결과 이력 값입니다";
    }

    public String calc() {
        String formula = Input.getFormula();
        return "계산 결과 값입니다";
    }

    private static int selectMenu() {
        Output.init();
        int menu = Input.selectMenu();
        Output.blankLine();
        return menu;
    }
}
