package engine.compute.converter;

import engine.compute.validator.ExpressionValidator;
import engine.model.Token;
import engine.compute.operate.Operator;

import java.util.*;
import java.util.stream.Collectors;

import static engine.compute.operate.Operator.*;


public class ExpressionConverter {
    private final ExpressionValidator expressionValidator;

    public ExpressionConverter(ExpressionValidator expressionValidator) {
        this.expressionValidator = expressionValidator;
    }

    public List<Token> convertUserInputToTokenList(String userInput) {
        String operatorRegEx = "(?=[+/*-])|(?<=[+/*-])";
        List<Token> tokenList = Arrays.stream(userInput.split(operatorRegEx))
                .map(dividedInput -> new Token(dividedInput.trim()))
                .collect(Collectors.toList());

        return tokenList;
    }

    public List<Token> convertToPostFix(List<Token> availTokens) {
        List<Token> postFix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (Token token : availTokens) {
            if (expressionValidator.isNumber(token)) {
                postFix.add(token);
            } else {
                sortOperatorByPriority(postFix, stack, token);
            }
        }
        while (!stack.isEmpty()) {
            postFix.add(new Token(stack.pop()));
        }

        return postFix;
    }

    private void sortOperatorByPriority(List<Token> postFix, Stack<String> stack, Token token) {
        String operator = token.getToken();
        Operator operatorEnum = getOperator(operator);

        switch (operatorEnum) {
            case PLUS:
            case MINUS:
            case MULTIPLY:
            case DIVIDE:

                while (!stack.isEmpty() && isHigherPriority(stack.peek(), operator)) {
                    postFix.add(new Token(stack.pop()));
                }

                stack.push(operator);
                break;
        }
    }

    private boolean isHigherPriority(String stackPeekOne, String newOne) {
        int stackPeekOnePriority = getOperator(stackPeekOne).getPriority();
        int nextOperatorPriority = getOperator(newOne).getPriority();

        return stackPeekOnePriority >= nextOperatorPriority;
    }
}
