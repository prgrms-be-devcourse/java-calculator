package com.programmers.converter;

import com.programmers.exception.WrongInputExpressionException;
import com.programmers.util.ConstantRegex;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InfixToPostfixConverter implements ExpressionConverter {
    @Override
    public List<String> convert(String expression) {
        // Stack 클래스를 사용 할 수 있으나, Stack 은 동기화 처리로 인한 성능 저하 문제가 있으므로, 자바의 권장사항대로 Deque 를 선택하였습니다.
        Deque<Operator> stack = new ArrayDeque<>();

        List<String> expressionTokenList = makeExpressionToken(expression);
        List<String> postFixTokenList = new ArrayList<>();

        for(int i = 0; i < expressionTokenList.size(); i++) {
            String token = expressionTokenList.get(i);

            if(token.equals("(")) {
                stack.push(Operator.OPEN_PARENTHESES);
            } else if(Operator.isOperator(token)){
                Operator operator = Operator.getOperation(token);

                while(!stack.isEmpty() && stack.peek().compareTo(operator.getPriority()) >= 0) {
                    postFixTokenList.add(stack.pop().getSymbol());
                }
                stack.push(operator);
            } else if (token.equals(")")) {
                Operator pop = stack.pop();
                while(!stack.isEmpty() && !pop.isOpenParentheses()) {
                    postFixTokenList.add(pop.getSymbol());
                    pop = stack.pop();
                }
            } else {
                postFixTokenList.add(token);
            }
        }

        while(!stack.isEmpty()) {
            postFixTokenList.add(stack.pop().getSymbol());
        }

        return postFixTokenList;
    }

    private List<String> makeExpressionToken(String expression) {

        validateInputExpression(expression);

        Pattern pattern = Pattern.compile(ConstantRegex.EXPRESSION_FILTER_REGEX);
        Matcher matcher = pattern.matcher(expression);
        List<String> filterExpression = new ArrayList<>();

        while(matcher.find()) {
            filterExpression.add(matcher.group());
        }

        return filterExpression;
    }

    private void validateInputExpression(String expression) {
        Arrays.stream(expression.split(ConstantRegex.EXPRESSION_VALIDATION_REGEX))
                .findAny()
                .ifPresent(p -> {
                    throw new WrongInputExpressionException("수식은 숫자와 +, -, *, /, ( , )만 입력이 가능합니다.");
                });

        if(!isParenthesesOrder(expression)) {
            throw new WrongInputExpressionException("괄호의 순서가 잘못되었습니다.");
        }
    }

    private boolean isParenthesesOrder(String expression) {
        Deque<Character> stack = new ArrayDeque<>();

        if (expression.contains("(")) {
            for (char ch : expression.toCharArray()) {
                if (ch == '(') {
                    if (!stack.isEmpty() && stack.peek() == ')') {
                        return false;
                    }
                    stack.push(ch);
                } else if (ch == ')'){
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }
        return true;
    }


}
