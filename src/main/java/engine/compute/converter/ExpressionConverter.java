package engine.compute.converter;

import engine.compute.validator.ExpressionValidator;
import engine.model.Token;
import engine.compute.operate.Operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import static engine.compute.operate.Operator.*;


public class ExpressionConverter {
    private final ExpressionValidator expressionValidator;

    public ExpressionConverter(ExpressionValidator expressionValidator) {
        this.expressionValidator = expressionValidator;
    }

    public List<Token> convertUserInputToToken(String input) {
        List<Token> tokenList = new ArrayList<>();

        Arrays.stream(input.split("(?=[+/*-])|(?<=[+/*-])"))
                .forEach(s -> tokenList.add(new Token(s.trim())));

        return tokenList;
    }

    public List<Token> convertToPostFix(List<Token> availTokens) {
        List<Token> postFix = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (Token token : availTokens) {
            if (expressionValidator.isNumber(token)) {
                postFix.add(token);
            } else {
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
        }
        while (!stack.isEmpty()) {
            postFix.add(new Token(stack.pop()));
        }

        return postFix;
    }

    private boolean isHigherPriority(String peek, String newOne) {
        int stackPeekOnePriority = getOperator(peek).getPriority();
        int nextOperatorPriority = getOperator(newOne).getPriority();

        return stackPeekOnePriority >= nextOperatorPriority;
    }
}
