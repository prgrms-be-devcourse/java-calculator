package com.project.java.engine.solver;

import com.project.java.engine.data.ResultFormat;
import com.project.java.exception.ContinuousOperatorException;
import com.project.java.exception.ZeroDivisionException;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@AllArgsConstructor
public class StackSolver implements Solver {

    private static final String OPER_REGULAR = "[+\\-*/]";
    private static final String NUMBER_REGULAR = "[0-9]+";
    private PriorityStrategy priorityStrategy;

    @Override
    public ResultFormat calculate(String expression) throws ZeroDivisionException, ContinuousOperatorException {
        List<String> expressionList = makeExpressionToList(expression);
        List<String> postfix = convertInfix(expressionList);
        double result = calculatePostfix(postfix);

        String convertedExpression = convertExpression(expressionList);

        return new ResultFormat(convertedExpression, result);
    }

    @Override
    public String convertExpression(List<String> expression) {
        StringBuffer sb = new StringBuffer();
        for (String element : expression) sb.append(element).append(" ");
        sb.append("= ");
        return sb.toString();
    }


    @Override
    public List<String> convertInfix(List<String> infix) {
        Stack<String> stack = new Stack<>();
        List<String> postfix = new ArrayList<>();
        for (String element : infix) {
            fillPostfix(stack, postfix, element);
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
        return postfix;
    }

    private void fillPostfix(Stack<String> stack, List<String> postfix, String element) {
        if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
            int priority = getPriority(element);
            // 우선순위가 높은 연산자들은 postfix에 넣음.
            dumpHigherPriorityOperator(stack, postfix, priority);
            stack.push(element);
        } else {
            postfix.add(element);
        }
    }

    private void dumpHigherPriorityOperator(Stack<String> stack, List<String> postfix, int priority) {
        while (!stack.isEmpty() && priority <= getPriority(stack.peek())) {
            postfix.add(stack.pop());
        }
    }

    @Override
    public int getPriority(String oper) {
        return priorityStrategy.getPriority(oper);
    }

    private List<String> makeExpressionToList(String expression) throws ContinuousOperatorException {
        List<String> splittedValues = new ArrayList<>();
        expression = expression.replace(" ", "");
        String[] nums = expression.split(OPER_REGULAR);
        String[] opers = expression.split(NUMBER_REGULAR);

        // Validate 위치..
        if(isContinuousOperator(nums, opers)) throw new ContinuousOperatorException("연산자는 연속될 수 없습니다.");

        // 0001 0002 제거하기 위해 Long.parseLong 후 String.valueOf
        splittedValues.add(String.valueOf(Long.parseLong(nums[0])));
        for (int i = 1; i < opers.length; i++) {
            splittedValues.add(opers[i]);
            splittedValues.add(String.valueOf(Long.parseLong(nums[i])));
        }
        return splittedValues;
    }

    private boolean isContinuousOperator(String[] nums, String[] opers) {
        return nums.length != opers.length;
    }

    private double calculatePostfix(List<String> postfix) throws ZeroDivisionException {
        Stack<Double> stack = new Stack<>();

        for (String element : postfix) {
            if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
                double second = stack.pop();
                double first = stack.pop();
                if (element.equals("/") && second == 0) throw new ZeroDivisionException("0으로 나눌 수 없습니다.");
                priorityStrategy.operate(stack, element, second, first);
            } else {
                stack.push(Double.parseDouble(element));
            }
        }
        return stack.pop();
    }
}
