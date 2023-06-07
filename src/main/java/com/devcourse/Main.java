package com.devcourse;

import com.devcourse.calc.Calculator;
import com.devcourse.calc.func.ConverterNoBracket;
import com.devcourse.calc.repo.CalcHistoryRepository;
import com.devcourse.calc.func.ConverterWithBracket;
import com.devcourse.view.Input;
import com.devcourse.view.Output;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new CalcHistoryRepository(), new ConverterNoBracket());
        while (true) {
            try {
                int menu = selectMenu();
                Output.viewResult(calculator.run(menu));
            } catch (RuntimeException e) {
                Output.viewResult(e.getMessage());
            }
        }
    }

    private static int selectMenu() {
        Output.init();
        int menu = Input.selectMenu();
        Output.blankLine();
        return menu;
    }
}