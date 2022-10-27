package com.programmers.java.engine.calculator;

import com.programmers.java.application.Operator;
import com.programmers.java.application.config.Validator;
import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Expression;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.regex.Pattern;

import static com.programmers.java.application.config.Constant.*;

@AllArgsConstructor
public class CalculatorImpl implements Calculator {

    private Validator validator;

    @Override
    public Answer getAnswer(Expression expression) {

        // 후위연산으로 식 변경
        String[] postTokens = makePostfix(expression.getTokens());

        // 식 계산
        Answer result = calculate(postTokens);

        return result;
    }

    @Override
    public Answer calculate(String[] postTokens) {
        Stack<Double> stack = new Stack<>();
        Double lhs = 0.0;
        Double rhs = 0.0;

        for (String token : postTokens) {
            if (isMatchRegex(token, NUMBER_REGEX)) {
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

    private boolean isMatchRegex(String token, String regex) {
        return Pattern.matches(regex, token);
    }

    @Override
    public String[] makePostfix(String[] tokens) {
        Stack<String> stack = new Stack<>();
        String[] postTokens = new String[tokens.length];
        int index = 0;

        for (String token : tokens) {
            if (isMatchRegex(token, ALL_OPERATOR_REGEX)) {
                while (!stack.isEmpty() && (getRank(token) <= (getRank(stack.peek())))) {
                    postTokens[index++] = stack.pop();
                }
                stack.push(token);
            } else if (isMatchRegex(token, NUMBER_REGEX)) {
                postTokens[index++] = token;
            }
        }

        while (!stack.isEmpty()) {
            postTokens[index++] = stack.pop();
        }

        return postTokens;
    }

    // 연산자 우선순위 파악, 숫자 높을 수록 우선순위 높음
    private Integer getRank(String token) {
        if (isMatchRegex(token, ADD_MINUS_OPERATOR_REGEX)) {
            return 1;
        } else {
            return 2;
        }
    }

    private String makeNonSpaceString(String input) {
        return input.replace(" ", "");
    }

    public String[] numberOperatorTokenizer(String str) {
        return str.split(SPLIT_TOKENIZER_REGEX);
    }

    private void validateExpression(String expression) throws Exception {
        // validate: 식을 입력하지 않았을 경우
        validator.validEmptyExpression(expression);

        // validate: 숫자만 입력할 경우
        validator.validateOnlyNumber(expression);

        // validate: 0으로 나눈 경우
        validator.validZeroDivisionExpression(expression);

        // validate: 연산자 순서를 잘못 입력했을 경우 (-,+ 다음 /, *)
        validator.validWrongOrderOperator(expression);
    }

    private void validateTokens(String[] tokens) {
        // validate: 숫자와 연산자 이외에 문자가 있는 경우
        validator.validateNumberOperator(tokens);

        // validate: 최대 크기 보다 큰 경우
        validator.validateOutBoundNumber(tokens);
    }

    private String[] strListToStrArray(List<String> list) {
        String[] array = new String[list.size()];
        return list.toArray(array);
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
        validateExpression(nonSpaceExpression);

        // 공백 제거
        // 숫자와 연산자 추출
        String[] tokens = numberOperatorTokenizer(nonSpaceExpression);

        // validate tokens
        validateTokens(tokens);

        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
        List<String> expressionTokenList = combineUnaryOperator(tokenList);

        return Expression.builder()
                .tokens(strListToStrArray(expressionTokenList))
                .build();
    }

}
