package engine.model;

import engine.compute.validator.ExpressionValidator;
import engine.operate.Operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InputExpressionFactory {
    ExpressionValidator expressionValidator;

    public InputExpressionFactory(ExpressionValidator expressionValidator) {
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
        Stack<String> st = new Stack<>();

        for (Token token : availTokens) {
            if (expressionValidator.isNumber(token)) {
                postFix.add(token);
            }
            else{
                String operator = token.getToken();
                switch (operator){
                    case "+":
                    case "-":
                    case "*":
                    case "/":

                        while(!st.isEmpty() && isHigherPriority(st.peek(), operator)){
                            postFix.add(new Token(st.pop()));
                        }

                        st.push(operator);
                        break;
                }
            }
        }
        while (!st.isEmpty()) {
            postFix.add(new Token(st.pop()));
        }

        return postFix;
    }

    private boolean isHigherPriority(String peek, String newOne) {
        int stackPeekOnePriority = Operator.getOperator(peek).getPriority();
        int nextOperatorPriority = Operator.getOperator(newOne).getPriority();

        return stackPeekOnePriority >= nextOperatorPriority ? true : false;
    }
}
