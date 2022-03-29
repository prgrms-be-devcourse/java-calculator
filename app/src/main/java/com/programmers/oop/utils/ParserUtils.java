package com.programmers.oop.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.programmers.oop.type.Operator;

public class ParserUtils {

    private static final char OPEN_BRACKET = '(';
    private static final char CLOSE_BRACKET = ')';

    /**
     * what : infix -> postfix
     * why : 계산을 하기 위한 표현법 변환
     * worries : 로직이 너무 긴가.. , StringBuffer new 로 재생성...
     *
     * @param formula : 유효성 검증을 통과하고 whitepace 제거 후 넘어온 매개 변수
     * @return
     */
    public static List<String> toPostFix(String formula) {
        List<String> postfix = new ArrayList<>();
        StringBuilder numbers = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char current : formula.toCharArray()) {
            if (current >= '0' && current <= '9') {
                numbers.append(current);
            } else {
                if (current == OPEN_BRACKET) {
                    stack.push(current);
                } else if (current == CLOSE_BRACKET) {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        numbers.append(stack.pop());
                    }
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                } else if (OperatorUtils.isProperOpertatorYn(current)) {
                    postfix.add(numbers.toString());
                    numbers = new StringBuilder();
                    Operator putting = OperatorUtils.getOperator(current);
                    while (!stack.isEmpty() && OperatorUtils.getOperator(stack.peek())
                        .isPriorityYn(putting)) {
                        postfix.add(Character.toString(stack.pop()));
                    }
                    stack.push(current);
                }
            }
        }
        postfix.add(numbers.toString());
        while (!stack.isEmpty()) {
            postfix.add(Character.toString(stack.pop()));
        }

        return postfix;
    }

    /**
     * worries : naming 다시 생각해봐야함... 애매함
     *
     * @param list
     * @return
     */
    public static String toString(List<String> list) {
        StringBuilder answer = new StringBuilder();
        list.stream().forEach(value -> answer.append(value + "\n"));
        return answer.toString();
    }


}
