package com.devcourse.calc;

import com.devcourse.calc.model.*;
import com.devcourse.calc.model.Number;
import com.devcourse.calc.repo.CalcHistoryRepository;
import com.devcourse.util.Converter;

import java.util.List;
import java.util.Stack;

public class Calculator {

    private final CalcHistoryRepository repository;
    private final Converter converter;

    public Calculator(CalcHistoryRepository repository, Converter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public String run(int menu) {
        return Menu.doAction(menu, this);
    }

    public String showHistory() {
        return repository.getAllHistories();
    }

    public Number calculate(String formula) {
        List<Token> tokens = converter.infixToPostfixFormula(formula);
        Number result = calculate(tokens);
        repository.saveHistory(new History(formula, result.getNumber()));
        return result;
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
            Operator operator = (Operator) token;
            stack.push(operator.execute(secondNumber, firstNumber));
        }
        return new Number(stack.pop());
    }
}
