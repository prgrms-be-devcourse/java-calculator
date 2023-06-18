package com.programmers.domain;

import com.programmers.io.Console;

import java.util.List;
import java.util.Stack;

import static com.programmers.domain.Operator.findOperator;

public class Calculator {

    private final Console console;
    private final PostfixConverter postfixConverter = new PostfixConverter();
    private final CalculatorRepository calculatorRepository = new CalculatorRepository();

    public Calculator(Console console) {
        this.console = console;
    }

    public void calculate() {
        List<String> expression = console.getValidatedExpression();
        List<String> postfix = postfixConverter.convertInfixToPostfix(expression);

        int result = calculatePostfix(postfix);
        console.printResult(result);

        saveExpressionResult(expression, result);
    }

    public int calculatePostfix(List<String> postfix) {
        Stack<Integer> stack = new Stack<>();

        for (String token : postfix) {
            handleStack(token, stack);
        }

        return stack.pop();
    }

    public void handleStack(String token, Stack<Integer> stack) {
        if (postfixConverter.isNumeric(token)) {
            int num = Integer.parseInt(token);
            stack.push(num);
            return;
        }

        int result = operate(stack, token);
        stack.push(result);
    }

    public int operate(Stack<Integer> stack, String token) {
        int num2 = stack.pop();
        int num1 = stack.pop();

        Operator operator = findOperator(token);
        return operator.calculate(num1, num2);
    }

    public void saveExpressionResult(List<String> expression, int result) {
        String s = rearrangeExpression(expression, result);
        calculatorRepository.save(s);
    }

    public String rearrangeExpression(List<String> expression, int result) {
        String collect = String.join(" ", expression);

        return collect + " = " + result;
    }
}
