package com.devcourse.calc;

import com.devcourse.calc.model.Token;

import java.util.List;
import java.util.Stack;

public class Calculator {

    public int calculate(List<Token> mathSymbols) {
        Stack<Integer> calculationResult = new Stack<>();
        for (Token mathSymbol : mathSymbols) {
            if (mathSymbol.isDigit()) {
                calculationResult.push(mathSymbol.getProcessedNumber());
                continue;
            }

            Integer firstNumber = calculationResult.pop();
            Integer secondNumber = calculationResult.pop();
            calculationResult.push(mathSymbol.getProcessedNumber(secondNumber, firstNumber));
        }

        return calculationResult.pop();
    }

}
