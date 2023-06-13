package com.devcourse.calc;

import com.devcourse.calc.converter.Converter;
import com.devcourse.calc.model.*;
import com.devcourse.calc.repo.CalcHistoryRepository;

import java.util.List;
import java.util.Stack;

public class Calculator {

    private final CalcHistoryRepository repository;
    private final Converter converter;

    public Calculator(CalcHistoryRepository repository, Converter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public String run(int menuNumber) {
        Menu selectedMenu = Menu.find(menuNumber);

        return selectedMenu.execute(this);
    }

    public CalculateRecord showHistory() {
        return repository.getAllHistories();
    }

    public int calculate(String formula) {
        List<Token> tokens = converter.convertFormula(formula);
        int result = calculate(tokens);
        saveCalculateHistory(formula, result);

        return result;
    }

    private int calculate(List<Token> mathSymbols) {
        Stack<Integer> calculationResult = new Stack<>();
        mathSymbols.forEach(symbol -> symbol.deal(calculationResult));

        return calculationResult.pop();
    }

    private void saveCalculateHistory(String formula, int calculate) {
        History history = new History(formula, calculate);
        repository.saveHistory(history);
    }
}
