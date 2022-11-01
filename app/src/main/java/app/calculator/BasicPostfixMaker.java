package app.calculator;

import app.validator.RegexConstant;

import java.util.*;

// 후위표현식을 List 형태로 반환
public class BasicPostfixMaker implements PostfixMaker{

    // 연산식 리스트 -> 후위식 표기법 리스트로 변환
    @Override
    public List<String> makePostfix(Expression expression) {

        Deque<String> stack = new ArrayDeque<>();
        List<String> expressionList = makeExpressionList(expression.getExpressionValue());
        List<String> postfixList = new ArrayList<>();

        expressionList.forEach(val -> {
                    if (val.matches(RegexConstant.NUMBERS)) {
                        postfixList.add(val);
                    } else {
                        fillStackWithOperators(stack, val, postfixList);
                    }});

        while (!stack.isEmpty()) postfixList.add(stack.pop());

        return postfixList;
    }

    private void fillStackWithOperators(Deque<String> stack, String operator, List<String> postfixList) {
        if (stack.isEmpty() || isNowOperatorHigherPriority(stack.peek(), operator)) {
            stack.push(operator);
        } else {
            while (!stack.isEmpty() && !isNowOperatorHigherPriority(stack.peek(), operator)) {
                postfixList.add(stack.pop());
            }
            stack.push(operator);
        }
    }

    // 연산식 문자열 -> 연산식 리스트
    private List<String> makeExpressionList(String expresionValue) {

        List<String> expressionList = new ArrayList<>();
        StringBuilder numberStringBuilder = new StringBuilder();

        for (char val : expresionValue.replaceAll(RegexConstant.WHITESPACE, "").toCharArray()) {
            if (Character.isDigit(val)) {
                numberStringBuilder.append(val);
            } else {
                expressionList.add(numberStringBuilder.toString());
                expressionList.add(String.valueOf(val));
                numberStringBuilder.setLength(0);
            }
        }
        expressionList.add(numberStringBuilder.toString());
        return expressionList;
    }

    // 스택에 쌓여있는 연산자 간의 우선순위를 판단
    private boolean isNowOperatorHigherPriority(String prev, String now) {
        return Operator.findPriority(prev) < Operator.findPriority(now);
    }
}
