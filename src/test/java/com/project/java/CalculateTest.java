package com.project.java;

import com.project.java.exception.ZeroDivisionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CalculateTest {

    private static final String OPER_REGULAR = "[+\\-*/]";
    private static final String NUMBER_REGULAR = "[0-9]+";

    @Test
    public void expressionToList() throws Exception {
        //given
        String expression = "1 34+ 2 * 3";
        ArrayList<String> splittedValues = new ArrayList<>();
        // when
        expression = expression.replace(" ", "");
        String[] nums = expression.split(OPER_REGULAR);
        String[] opers = expression.split(NUMBER_REGULAR);
        splittedValues.add(String.valueOf(Integer.parseInt(nums[0])));
        for (int i = 1; i < opers.length; i++) {
            splittedValues.add(opers[i]);
            splittedValues.add(String.valueOf(Integer.parseInt(nums[i])));
        }
        //then
        Assertions.assertLinesMatch(splittedValues, List.of("134", "+", "2", "*", "3"));
    }

    @Test
    public void infixToPostFix() throws Exception {
        //given
        ArrayList<String> infix = new ArrayList<String>(List.of("134", "+", "2", "*", "3"));
        Stack<String> stack = new Stack<>();
        ArrayList<String> postfix = new ArrayList<>();
        // when
        for (String element : infix) {
            if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
                int priority = getPriority(element);
                while (!stack.isEmpty() && priority <= getPriority(stack.peek())) {
                    postfix.add(stack.pop());
                }
                stack.push(element);
            } else {
                postfix.add(element);
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
        //then
        Assertions.assertLinesMatch(postfix, List.of("134", "2", "3", "*", "+"));
    }

    int getPriority(String oper) {
        if (oper.equals("+") || oper.equals("-")) return 1;
        else return 2;
    }

    @Test
    public void calculatePostfix() throws Exception {
        //given
        ArrayList<String> postfix = new ArrayList<>(List.of("134", "2", "3", "*", "+", "6", "+"));
        Stack<Integer> stack = new Stack<>();
        // when
        for (String element : postfix) {
            if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
                int second = stack.pop();
                int first = stack.pop();
                if (element.equals("/") && second == 0) throw new ZeroDivisionException("0으로 나눌 수 없습니다.");
                switch (element) {
                    case "+":
                        stack.push(first + second);
                        break;
                    case "-":
                        stack.push(first - second);
                        break;
                    case "*":
                        stack.push(first * second);
                        break;
                    case "/":
                        stack.push(first / second);
                        break;
                }
            } else {
                stack.push(Integer.parseInt(element));
            }
        }
        //then
        Assertions.assertEquals(stack.pop(), 146);
    }
}
