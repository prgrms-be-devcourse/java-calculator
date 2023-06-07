package com.devcourse.calc;

import com.devcourse.calc.model.*;
import com.devcourse.calc.model.Operand;
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
        return Menu.execute(menu, this);
    }

    public String showHistory() {
        return repository.getAllHistories();
    }

    public Operand calculate(String formula) {
        List<Token> tokens = converter.infixToPostfixFormula(formula);
        Operand result = calculate(tokens);
        repository.saveHistory(new History(formula, result.getNumber()));
        return result;
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
}
