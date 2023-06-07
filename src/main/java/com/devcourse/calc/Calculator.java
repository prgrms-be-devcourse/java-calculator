package com.devcourse.calc;

import com.devcourse.calc.model.*;
import com.devcourse.calc.model.Operand;
import com.devcourse.calc.repo.CalcHistoryRepository;
import com.devcourse.calc.func.Converter;

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
        Object result = selectedMenu.execute(this);
        return processResult(result);
    }

    public String showHistory() {
        List<History> histories = repository.getAllHistories();
        StringBuilder result = new StringBuilder();
        for (History history : histories) {
            result.append(history);
        }
        return result.toString();
    }

    public History calculate(String formula) {
        List<Token> tokens = converter.infixToPostfixFormula(formula);
        Operand result = calculate(tokens);
        return new History(formula, result.getNumber());
    }

    private Operand calculate(List<Token> mathSymbols) {
        Stack<Integer> calculationResult = new Stack<>();
        for (Token symbol : mathSymbols) {
            if (symbol instanceof Operand number) {
                calculationResult.push(number.getNumber());
                continue;
            }

            Integer firstNumber = calculationResult.pop();
            Integer secondNumber = calculationResult.pop();
            Operator operator = (Operator) symbol;
            calculationResult.push(operator.execute(secondNumber, firstNumber));
        }
        return new Operand(calculationResult.pop());
    }

    private String processResult(Object result) {
        if (result instanceof History history) {
            repository.saveHistory(history);
            return String.format("%d\n", history.getResult());
        }
        return result.toString();
    }
}
