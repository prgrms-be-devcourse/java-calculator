package com.devcourse;

import com.devcourse.calc.Calculator;
import com.devcourse.calc.repo.CalcHistoryRepository;
import com.devcourse.calc.func.Converter;
import com.devcourse.view.Input;
import com.devcourse.view.Output;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new CalcHistoryRepository(), new Converter());
        while (true) {
            int menu = selectMenu();
            Output.viewResult(calculator.run(menu));
        }
    }

    private static int selectMenu() {
        Output.init();
        int menu = Input.selectMenu();
        Output.blankLine();
        return menu;
    }
}