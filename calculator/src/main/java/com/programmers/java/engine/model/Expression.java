package com.programmers.java.engine.model;

import com.programmers.java.application.config.Validator;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

import static com.programmers.java.application.config.Constant.ADD_MINUS_OPERATOR_REGEX;
import static com.programmers.java.application.config.Constant.ALL_OPERATOR_REGEX;

@Getter
@ToString
public class Expression {
    private List<String> tokens;

    @Builder
    public Expression(List<String> tokens, Validator validator) {
        if (validator != null) {
            validator.validateTokens(tokens);
        }

        List<String> expressionTokenList = combineUnaryOperator(tokens);

        this.tokens = expressionTokenList;
    }

    private List<String> combineUnaryOperator(List<String> tokenList) {
        List<String> expressionTokenList = new LinkedList<>();

        String bufferToken = null;
        String firstToken = tokenList.get(0);

        expressionTokenList.add(firstToken);
        if (firstToken.equals("-")) {
            expressionTokenList.remove(0);
            expressionTokenList.add(firstToken + tokenList.get(1));
        }

        for (int i = 1; i < tokenList.size(); i++) {
            String curToken = tokenList.get(i);
            String prevToken = tokenList.get(i - 1);

            if (prevToken.matches(ALL_OPERATOR_REGEX) && curToken.matches(ADD_MINUS_OPERATOR_REGEX)) {
                String prevPrevToken = tokenList.get(i - 2);

                if (!prevPrevToken.matches(ADD_MINUS_OPERATOR_REGEX)) bufferToken = curToken;
                else break;

            } else if (bufferToken != null && bufferToken.equals("-")) {
                expressionTokenList.add(bufferToken + curToken);
                bufferToken = null;
            } else {
                expressionTokenList.add(curToken);
            }
        }

        if (firstToken.equals("+")) {
            expressionTokenList.remove(0);
        } else if (firstToken.equals("-")) {
            expressionTokenList.remove(1);
        }

        return expressionTokenList;
    }

    public StringExpression getStringExpression() {
        return StringExpression.builder()
                .value(String.join(" ", tokens))
                .build();
    }
}
