package com.programmers.converter;

import com.programmers.util.ConstantRegex;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;

public class InfixToPostfixConverter implements ExpressionConverter {
    @Override
    public List<String> convert(String expression) {
        Deque<Operator> stack = new ArrayDeque<>();
        List<String> postFixTokenList = new ArrayList<>();
        List<String> expressionTokenList = makeExpressionToken(expression);

        for (String token : expressionTokenList) {
            makePostFixTokenList(token, postFixTokenList, stack);
        }

        while (!stack.isEmpty()) {
            postFixTokenList.add(stack.pop().getSymbol());
        }

        return postFixTokenList;
    }

    private void makePostFixTokenList(String token, List<String> postFixTokenList, Deque<Operator> stack) {

        if (token.equals("(")) {
            stack.push(Operator.OPEN_PARENTHESES);
            return;
        }

        if (Operator.isOperator(token)) {
            pushTokenPostfixListInStack(stack, postFixTokenList, token);
            return;
        }

        if (token.equals(")")) {
            pushTokenListUntilOpenBracket(stack, postFixTokenList);
            return;
        }

        postFixTokenList.add(token);
    }

    private void pushTokenListUntilOpenBracket(Deque<Operator> stack, List<String> postFixTokenList) {
        Operator pop = stack.pop();
        while (!stack.isEmpty() && !pop.isOpenParentheses()) {
            postFixTokenList.add(pop.getSymbol());
            pop = stack.pop();
        }
    }

    private void pushTokenPostfixListInStack(Deque<Operator> stack, List<String> postFixTokenList, String token) {
        Operator operator = Operator.getOperation(token);

        while (isLowerPriorityInStack(stack, operator)) {
            postFixTokenList.add(stack.pop().getSymbol());
        }

        stack.push(operator);
    }

    private boolean isLowerPriorityInStack(Deque<Operator> stack, Operator inputOperator) {
        if (stack.isEmpty())
            return false;

        Operator operatorInStack = stack.peek();
        return operatorInStack.isComparePriority(inputOperator);
    }

    private List<String> makeExpressionToken(String expression) {

        validateInputExpression(expression);

        Matcher matcher = ConstantRegex.EXPRESSION_FILTER_REGEX_COMPILE.matcher(expression);
        List<String> filterExpression = new ArrayList<>();

        while (matcher.find()) {
            filterExpression.add(matcher.group());
        }

        return filterExpression;
    }

    private void validateInputExpression(String expression) {

        if (ConstantRegex.EXPRESSION_VALIDATION_REGEX_COMPILE.matcher(expression).matches()) {
            throw new IllegalArgumentException("수식은 숫자와 +, -, *, /, ( , )만 입력이 가능합니다.");
        }

        if (!isParenthesesOrderCorrect(expression)) {
            throw new IllegalArgumentException("괄호의 순서가 잘못되었습니다.");
        }
    }

    private boolean isParenthesesOrderCorrect(String expression) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : expression.toCharArray()) {
            fillParenthesesStack(stack, ch);
        }
        return stack.isEmpty();
    }

    private void fillParenthesesStack(Deque<Character> stack, char ch) {

        if (ch == '(') {
            stack.push(ch);
            return;
        }

        if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
            return;
        }

        if (ch == ')') {
            stack.push(ch);
        }
    }


}
