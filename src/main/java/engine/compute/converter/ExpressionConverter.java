package engine.compute.converter;

import engine.compute.validator.ExpressionValidator;
import engine.model.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static engine.compute.operate.Operator.getOperator;


public class ExpressionConverter {
    public static final String operatorRegEx = "(?=[+/*-])|(?<=[+/*-])";
    private final ExpressionValidator expressionValidator;

    public ExpressionConverter(ExpressionValidator expressionValidator) {
        this.expressionValidator = expressionValidator;
    }

    public List<Token> convertUserInputToTokenList(String userInput) {
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
            }

            if (expressionValidator.isOperator(token)) {
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

        while (!stack.isEmpty() && isHigherPriority(stack.peek(), operator)) {
            postFix.add(new Token(stack.pop()));
        }

        stack.push(operator);

    }

    private boolean isHigherPriority(String stackPeekOne, String newOne) {
        int stackPeekOnePriority = getOperator(stackPeekOne).getPriority();
        int nextOperatorPriority = getOperator(newOne).getPriority();

        return stackPeekOnePriority >= nextOperatorPriority;
    }
}
