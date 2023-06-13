package com.programmers.service;

import com.programmers.domain.ExpressionValidator;
import com.programmers.domain.Operator;
import com.programmers.domain.PostfixConverter;
import com.programmers.domain.SelectionValidator;
import com.programmers.io.Console;

import java.util.List;
import java.util.Stack;

import static com.programmers.domain.Operator.findOperator;

public class CalculatorService {

    private final Console console;
    private final SelectionValidator selectionValidator = new SelectionValidator();
    private final ExpressionValidator expressionValidator = new ExpressionValidator();
    private final PostfixConverter postfixConverter = new PostfixConverter();

    public CalculatorService(Console console) {
        this.console = console;
    }

    public int getValidatedMenuSelection() {
        String selection = console.getSelection();

        try {
            selectionValidator.validate(selection);
            return Integer.parseInt(selection);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidatedMenuSelection();
        }
    }

    public List<String> getValidatedExpression() {
        String expression = console.getExpressionSpaceRemoved();

        try {
            return expressionValidator.validate(expression);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getValidatedExpression();
        }
    }

    public void calculate() {
        List<String> expression = getValidatedExpression();
        List<String> postfix = postfixConverter.convertInfixToPostfix(expression);

        int result = calculatePostfix(postfix);
        System.out.println(result + "\n");
    }

    public int calculatePostfix(List<String> postfix) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < postfix.size(); i++) {
            String token = postfix.get(i);

            if (postfixConverter.isNumeric(token)) {
                int num = Integer.parseInt(token);
                stack.push(num);
                continue;
            }

            int result = operate(stack, token);
            stack.push(result);
        }

        return stack.pop();
    }

    public int operate(Stack<Integer> stack, String token) {
        int num2 = stack.pop();
        int num1 = stack.pop();

        Operator operator = findOperator(token);
        return operator.calculate(num1, num2);
    }
}
