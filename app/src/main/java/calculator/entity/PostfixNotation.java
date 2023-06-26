package calculator.entity;

import static calculator.entity.Operator.getOperatorWithSameSymbol;
import static calculator.utils.StringUtils.isNumeric;
import static calculator.utils.StringUtils.splitToElements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class PostfixNotation implements Notation {

    @Override
    public String[] makeElements(String expression) {
        String[] infixElements = splitToElements(expression);

        return convertToPostfix(infixElements);
    }

    @Override
    public Optional<Expression> makeExpression(Stack<Integer> operands, Stack<Operator> operators,
        String element) {
        if (isNumeric(element)) {
            int operand = Integer.parseInt(element);
            operands.push(operand);

            return Optional.empty();
        }

        Operator operator = getOperatorWithSameSymbol(element);
        int operand2 = operands.pop();
        int operand1 = operands.pop();

        return Optional.of(new Expression(operator, operand1, operand2));
    }

    private String[] convertToPostfix(String[] elements) {
        List<String> postfixElements = new ArrayList<>();
        Stack<Operator> operators = new Stack<>();

        for (String element : elements) {
            saveElement(postfixElements, operators, element);
        }

        while (!operators.isEmpty()) {
            addTopOfOperatorStackToPostfixElements(postfixElements, operators);
        }

        return postfixElements.toArray(new String[0]);
    }

    private void saveElement(List<String> postfixElements, Stack<Operator> operators,
        String element) {
        if (isNumeric(element)) {
            postfixElements.add(element);

            return;
        }

        pushOperator(postfixElements, operators, element);
    }

    private void pushOperator(List<String> postfixElements, Stack<Operator> operators,
        String element) {
        Operator operator = getOperatorWithSameSymbol(element);

        while (isLowerOrSamePriorityThanTop(operators, operator)) {
            addTopOfOperatorStackToPostfixElements(postfixElements, operators);
        }

        operators.push(operator);
    }

    private boolean isLowerOrSamePriorityThanTop(Stack<Operator> operators, Operator operator) {
        if (operators.isEmpty()) {
            return false;
        }

        Operator topOfStack = operators.peek();

        return operator.isLowerOrSamePriorityThan(topOfStack);
    }

    private void addTopOfOperatorStackToPostfixElements(List<String> postfixElements,
        Stack<Operator> operators) {
        Operator topOfStack = operators.pop();
        String symbol = topOfStack.getSymbol();

        postfixElements.add(symbol);
    }
}
