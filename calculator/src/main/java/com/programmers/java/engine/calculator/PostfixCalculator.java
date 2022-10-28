package com.programmers.java.engine.calculator;

import com.programmers.java.application.Operator;
import com.programmers.java.application.config.Validator;
import com.programmers.java.application.util.CalculatorUtils;
import com.programmers.java.application.util.PostfixUtils;
import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Expression;
import lombok.AllArgsConstructor;

import java.util.*;

import static com.programmers.java.application.config.Constant.*;
import static com.programmers.java.application.util.CalculatorUtils.*;

@AllArgsConstructor
public class PostfixCalculator implements Calculator {

    private Validator validator;
    private PostfixUtils postfixUtils;

    @Override
    public Answer getAnswer(Expression expression) {

        // 후위연산으로 식 변경
        List<String> postTokens = postfixUtils.makePostfix(expression);

        // 식 계산
        Answer result = calculate(postTokens);

        return result;
    }

    @Override
    public Answer calculate(List<String> postTokens) {
        Stack<Double> stack = new Stack<>();
        Double lhs = 0.0;
        Double rhs = 0.0;

        for (String token : postTokens) {
            if (CalculatorUtils.isMatchRegex(token, NUMBER_REGEX)) {
                stack.push(Double.parseDouble(token));
            } else if (isMatchRegex(token, ALL_OPERATOR_REGEX)) {
                rhs = stack.pop();
                lhs = stack.pop();

                Answer answer = Operator.calculate(token, lhs, rhs);
                stack.push(answer.getValue());
            }
        }

        return Answer.builder()
                .value(stack.peek())
                .build();
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

    @Override
    public Expression parseExpression(String inputExpression) throws Exception {
        String nonSpaceExpression = makeNonSpaceString(inputExpression);

        // validate expression
        validator.validateExpression(nonSpaceExpression);

        // 공백 제거
        // 숫자와 연산자 추출
        String[] tokens = numberOperatorTokenizer(nonSpaceExpression);

        // validate tokens
        validator.validateTokens(tokens);

        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
        List<String> expressionTokenList = combineUnaryOperator(tokenList);

        return Expression.builder()
                .tokens(expressionTokenList)
                .build();
    }

}
