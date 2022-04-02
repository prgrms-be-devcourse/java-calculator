package com.kimhunki.java.calculator.model;

import com.kimhunki.java.calculator.db.MemoryResultRepository;
import com.kimhunki.java.calculator.enums.Operations;
import com.kimhunki.java.calculator.strategy.CalculatorStrategy;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Stack;

@AllArgsConstructor
public class InfixCalculator implements CalculatorStrategy {
    Parser parser;
    Operator operator;

    @Override
    public String calculate(List<String> expressionList) {
        Stack<String> expressStack = new Stack<>();
        Operations parsing = Operations.NULL;
        double result = 0;
        for (String element : expressionList) // * , / 먼저 계산
        {

            if (parsing.equals(Operations.MUL) || parsing.equals(Operations.DIV)) {
                double num1 = Double.parseDouble(expressStack.pop()); // 팝
                double num2 = Double.parseDouble(element);
                if (parsing.equals(Operations.MUL))
                    expressStack.add(Double.toString(operator.operate(num1, num2, parsing)));
                else {
                    if (operator.operate(num1, num2, parsing) == -1) {
                        return "error";
                    }

                    expressStack.add(Double.toString(operator.operate(num1, num2, parsing)));
                }

                parsing = Operations.NULL;
            } else if (element.equals("*") || element.equals("/")) {
                parsing = parser.operParser(element);
            } else expressStack.add(element);
        }
        result = Double.parseDouble(expressStack.get(0)); // 초기값 결과에 넣어둠
        for (int i = 1; i < expressStack.size(); i += 2) {

            if (parser.operParser(expressStack.get(i)).equals(Operations.PLUS)) // +,-만 있으므로 뒤에 결과만 result에 더해줌
                result += Double.parseDouble(expressStack.get(i + 1));
            else result -= Double.parseDouble(expressStack.get(i + 1));
        }
        return Double.toString(result);

    }
}
