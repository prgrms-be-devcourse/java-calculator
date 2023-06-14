package com.devcourse;

import com.devcourse.calc.Calculator;
import com.devcourse.calc.converter.ConverterNoBracket;
import com.devcourse.calc.repo.CalcHistoryRepository;
import com.devcourse.view.Input;
import com.devcourse.view.Output;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new CalcHistoryRepository(), new ConverterNoBracket());
        while (true) {
            int menu = selectMenu();
            Output.viewResult(calculator.run(menu));
        }
    }

    private static int selectMenu() {
        Output.showMenus();
        int menu = Input.selectMenu();
        Output.blankLine();

        return menu;
    }
}