package com.devcourse.calc;

import com.devcourse.calc.model.*;
import com.devcourse.calc.model.Number;
import com.devcourse.calc.repo.CalcHistoryRepository;
import com.devcourse.util.Converter;
import com.devcourse.view.Input;
import com.devcourse.view.Output;

import java.util.List;
import java.util.Stack;

public class Calculator {

    private final CalcHistoryRepository repository;
    private final Converter converter;

    public Calculator(CalcHistoryRepository repository, Converter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public void run() {
        int menu = selectMenu();
        Output.viewResult(Menu.doAction(menu, this));
    }

    public String showHistory() {
        return repository.getAllHistories();
    }

    public String calc() {
        String formula = Input.getFormula();
        List<Token> tokens = converter.infixToPostfixFormula(formula);
        String result = calculate(tokens).toString();
        repository.saveHistory(new History(formula, result));
        return result;
    }

    private static int selectMenu() {
        Output.init();
        int menu = Input.selectMenu();
        Output.blankLine();
        return menu;
    }

    private Number calculate(List<Token> tokens) {
        Stack<Integer> stack = new Stack<>();
        for (Token token : tokens) {
            if (token instanceof Number number) {
                stack.push(number.getNumber());
                continue;
            }

            Integer firstNumber = stack.pop();
            Integer secondNumber = stack.pop();
            stack.push(((Operator) token).doAction(secondNumber, firstNumber));
        }
        return new Number(stack.pop());
    }
}
