package com.programmers.kwonjoosung.java.calculator.service;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;

public class BasicCalculator implements Calculator { // deque 자료구조를 활용하여 rotate 하면서 계산하기
    private final static String ADD = "+";
    private final static String SUB = "-";
    private final static String MUL = "*";
    private final static String DIV = "/";
    private final DecimalFormat FORMAT = new DecimalFormat("#.##");

    /**
     * 더하기, 빼기, 곱하기, 나누기
     * <p>
     * 연산자 우선순위 적용
     * </p>
     *
     * @param expression 계산하고 싶은 식
     * @return 계산된 결과
     */
    @Override
    public String calculate(String[] expression) {
        // 우선 순위 연산을 먼저 적용하고 남은 식을 다음 계산에서 진행한 후에 결과 반환
        return calculateNext(
                calculatePriority(
                        Arrays.stream(expression).iterator()));
    }

    private ArrayDeque<String> calculatePriority(Iterator<String> expression) {
        // 우선 연산 오직 곱셈과 나눗셈만 가능
        ArrayDeque<String> deque = new ArrayDeque<>();

        while (expression.hasNext()) {
            String data = expression.next();
            if (MUL.equals(data) || DIV.equals(data)) {
                String prev = deque.pollLast();
                String next = expression.next();
                data = MUL.equals(data) ? multiply(prev, next) : divide(prev, next);
            }
            deque.addLast(data);
        }
        return deque;
    }

    private String calculateNext(ArrayDeque<String> expression) {
        // 나중 연산 오직 덧셈과 뺄셈만 가능
        while (expression.size() > 1) {
            String data = expression.pollFirst();
            if (ADD.equals(data) || SUB.equals(data)) {
                String prev = expression.pollLast();
                String next = expression.pollFirst();
                data = ADD.equals(data) ? add(prev, next) : subtract(prev, next);
                expression.addFirst(data);
                continue;
            }
            expression.addLast(data);
        }
        return expression.poll();
    }

    private String add(String x, String y) {
        return FORMAT.format(Double.parseDouble(x) + Double.parseDouble(y));
    }

    private String subtract(String x, String y) {
        return FORMAT.format(Double.parseDouble(x) - Double.parseDouble(y));
    }

    private String multiply(String x, String y) {
        return FORMAT.format(Double.parseDouble(x) * Double.parseDouble(y));
    }

    private String divide(String x, String y) throws ArithmeticException {
        double result = Double.parseDouble(x) / Double.parseDouble(y);
        if (Double.isInfinite(result) || Double.isNaN(result))
            throw new IllegalArgumentException("계산할 수 없는 연산입니다.");
        return FORMAT.format(result);
    }
}
