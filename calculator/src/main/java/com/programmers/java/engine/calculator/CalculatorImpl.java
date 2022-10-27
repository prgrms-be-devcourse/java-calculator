package com.programmers.java.engine.calculator;

import com.programmers.java.application.Operator;
import com.programmers.java.application.exception.*;
import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Expression;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.regex.Pattern;

import static com.programmers.java.application.config.Constant.*;

@AllArgsConstructor
public class CalculatorImpl implements Calculator {

    @Override
    public Answer calculate(Expression expression) {

        // 후위연산으로 식 변경
        String[] postTokens = makePostfix(expression.getTokens());

        // 식 계산
        Answer result = getResult(postTokens);

        return result;
    }

    @Override
    public Answer getResult(String[] postTokens) {
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

    // 공백 제거
    private String makeNonSpaceString(String input) {
        return input.replace(" ", "");
    }

    // 숫자와 연산자로 토큰화
    public String[] numberOperatorTokenizer(String str) {
        return str.split(SPLIT_TOKENIZER_REGEX);
    }

    private void validEmptyExpression(String expression) throws EmptyExpressionException {
        if (expression.length() == 0) {
            throw new EmptyExpressionException();
        }
    }

    private void validateOnlyNumber(String expression) throws OnlyNumberException {
        if (Pattern.matches(NUMBER_REGEX, expression)) {
            throw new OnlyNumberException();
        }
    }

    public void validZeroDivisionExpression(String expression) {
        if (Pattern.matches(ZERO_DIVIDE_REGEX, expression)) {
            throw new ZeroDivisionException();
        }
    }

    public void validWrongOrderOperator(String expression) throws WrongOrderOperatorException {
        if (Pattern.matches(ADD_MINUS_NEXT_MULTIPLY_DIVIDE_OPERATOR_REGEX, expression)) {
            throw new WrongOrderOperatorException();
        }
    }

    private void validMultiplyDivideDouble(String expression) throws DoubleMultiplyDivideException {
        if (Pattern.matches(DOUBLE_MULTIPLY_DIVIDE_OPERATOR_REGEX, expression)) {
            throw new DoubleMultiplyDivideException();
        }
    }


    private void validateExpression(String expression) throws Exception {
        // validate: 식을 입력하지 않았을 경우
        validEmptyExpression(expression);

        // validate: 숫자만 입력할 경우
        validateOnlyNumber(expression);

        // validate: 0으로 나눈 경우
        validZeroDivisionExpression(expression);

        // validate: 연산자 순서를 잘못 입력했을 경우 (-,+ 다음 /, *)
        validWrongOrderOperator(expression);

        // validate: 곱하기와 나누기 연산을 연속해서 2번 이상 했을 경우
        validMultiplyDivideDouble(expression);
    }

    private void validateTokens(String[] tokens) {
        // validate: 숫자와 연산자 이외에 문자가 있는 경우
        validateNumberOperator(tokens);

        // validate: 최대 크기 보다 큰 경우
        validateOutBoundNumber(tokens);
    }

    private void validateNumberOperator(String[] tokens) {
        for (String token : tokens) {
            if (!Pattern.matches(NUMBER_OPERATOR_REGEX, token)) {
                throw new NonNumberOperatorException();
            }
        }
    }

    private void validateOutBoundNumber(String[] tokens) {
        for (String token : tokens) {
            if (!Pattern.matches(AVAILABLE_VALUE_REGEX, token)) {
                throw new OutboundMaxValueException();
            }
        }
    }

    private String[] stringListToStringArray(List<String> list) {
        String[] array = new String[list.size()];
        return list.toArray(array);
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
        List<String> expressionTokenList = new LinkedList<>();

        String originToken = null;
        String firstToken = tokenList.get(0);
        String secondToken = tokenList.get(1);

        expressionTokenList.add(firstToken);
        if (firstToken.equals("-")) {
            expressionTokenList.remove(0);
            expressionTokenList.add(firstToken + secondToken);
        }

        for (int i = 1; i < tokenList.size(); i++) {
            String curToken = tokenList.get(i);
            String prevToken = tokenList.get(i - 1);

            if (prevToken.matches(ALL_OPERATOR_REGEX) && curToken.matches(ADD_MINUS_OPERATOR_REGEX)) {
                String prevPrevToken = tokenList.get(i - 2);

                if (!prevPrevToken.matches(ADD_MINUS_OPERATOR_REGEX)) originToken = curToken;
                else break;

            } else if (originToken != null && originToken.equals("-")) {
                expressionTokenList.add(originToken + curToken);
                originToken = null;
            } else {
                expressionTokenList.add(curToken);
            }
        }

        if (firstToken.equals("+")) {
            expressionTokenList.remove(0);
        } else if (firstToken.equals("-")) {
            expressionTokenList.remove(1);
        }

        return Expression.builder()
                .tokens(stringListToStringArray(expressionTokenList))
                .build();
    }

}
