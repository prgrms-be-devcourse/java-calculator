package com.caculator.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter {

    /**
     * 중위 표기식을 후위 표기식으로 변환하여 반환한다.
     *
     * 변환 과정
     * 1. 중위 표기식을 앞에서부터 탐색한다.
     * 2.
     * - 숫자인 경우 리스트에 add 한다.
     * - 연산자인 경우 우선 순위에 따라 처리된다.
     *   - 스택이 비어있거나 operator 가 스택에 있는 연산자들보다 우선 순위가 높은 경우 -> 스택에 push 한다.
     *   - operator 가 스택에 있는 연산자와 우선 순위가 낮거나 같은 경우 -> 스택에 남은 연산자들의 우선 순위가 operator 보다 낮을때까지 스택에서 pop 하여 후위표기식에 넣어준 후 operator 를 스택에 push 한다.
     * 3. 스택에 남은 연산자들을 pop 하여 리스트에 add 한다.
     * 4. 위의 과정을 거친 리스트는 후위 연산식이다.
     *
     * @throws IllegalArgumentException : 수식이 비어있거나, 연산자와 숫자의 순서가 올바르지 않은 경우(예: + 1 * 2) 던져진다.
     */
    public static List<String> convert(String expression) throws IllegalArgumentException {
        List<String> postfix = new ArrayList<>();
        String[] split = expression.split(" ");
        Stack<String> stack = new Stack<>();

        checkEmptyExpression(split);

        for (int i = 0; i < split.length; i++) {
            String s = split[i];

            if (isIdxForOperator(i)) { //수식의 순서상 연산자가 나와야하는 순서라면
                executeOperatorProcess(s, postfix, stack);
            } else {
                executeNumberProcess(s, postfix);
            }
        }

        while (!stack.isEmpty()) postfix.add(stack.pop());

        return postfix;
    }

    private static void checkEmptyExpression(String[] split) throws IllegalArgumentException{
        if (isEmptyExpression(split)) throw new IllegalArgumentException();
    }

    private static boolean isEmptyExpression(String[] expressions) {
        return expressions != null && expressions.length == 0;
    }

    /**
     * 후위 표기식 변환 과정에서 문자가 숫자인 경우 호출되며, 숫자를 후위표기식에 넣어준다.
     * @throws IllegalArgumentException : number 가 숫자가 아닌 경우 던져진다.
     */
    private static void executeNumberProcess(String number, List<String> postfix) throws IllegalArgumentException {
        if (!StringUtils.isNumber(number)) {
            throw new IllegalArgumentException();
        }
        postfix.add(number);
    }

    /**
     * 후위 표기식 변환 과정에서 문자가 연산자인 경우에 호출되며, 우선 순위에 따라 연산자가 처리된다.
     * @throws IllegalArgumentException : operator 가 연산자가 아닌 경우 던져진다.
     */
    private static void executeOperatorProcess(String operator, List<String> postfix, Stack<String> stack) throws IllegalArgumentException {
        if (!Operator.isOperator(operator)) throw new IllegalArgumentException();

        if (stack.isEmpty() || Priority.getPriority(stack.peek()) < Priority.getPriority(operator)) {
            stack.push(operator);
            return;
        }

        while (!stack.isEmpty() && Priority.getPriority(stack.peek()) >= Priority.getPriority(operator)) {
            postfix.add(stack.pop());
        }

        stack.push(operator);
    }

    private static boolean isIdxForOperator(int index) {
        return (index + 1) % 2 == 0;
    }
}
