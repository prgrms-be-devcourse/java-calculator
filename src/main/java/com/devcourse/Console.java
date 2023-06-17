package com.devcourse;

import com.devcourse.calc.Calculator;
import com.devcourse.calc.converter.Converter;
import com.devcourse.calc.model.History;
import com.devcourse.calc.model.Menu;
import com.devcourse.calc.model.Result;
import com.devcourse.calc.repo.CalcHistoryRepository;
import com.devcourse.view.Input;
import com.devcourse.view.Output;

public class Console {
    private final Calculator calculator;
    private final Converter converter;
    private final CalcHistoryRepository repository;

    public Console(Calculator calculator, Converter converter, CalcHistoryRepository repository) {
        this.calculator = calculator;
        this.converter = converter;
        this.repository = repository;
    }

    public void run() {
        while (true) {
            Menu selectedMenu = selectMenu();
            Output.viewResult(executeMenu(selectedMenu).toString());
        }
    }

    private Menu selectMenu() {
        Output.showMenus();
        int menuNumber = Input.selectMenuNumber();
        Output.blankLine();

        return Menu.find(menuNumber);
    }

    private Result executeMenu(Menu selectedMenu) {
        Result result = null;
        switch (selectedMenu) {
            case CALC -> {
                String formula = Input.getFormula();
                int calculatedResult = calculator.calculate(converter.convertFormula(formula));

                repository.saveHistory(new History(formula, calculatedResult));
                result = new Result(calculatedResult);
            }
            case HISTORY -> result = repository.getAllHistories();
        }

        return result;
    }
}
