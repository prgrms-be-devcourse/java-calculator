package com.bona.javacalculator.core;

public class Priority {

    public static int getOperationPriority(String operator) {

        switch (operator) {
            case "*":
            case "/":
                return 2;
            case "+":
            case "-":
                return 1;
            default:
                throw new IllegalStateException("유효하지 않은 연산자 입니다" + operator);
        }
    }

    //연산자 우선순위 비교
    public static int compareOperation(String operator, String NowOperator) {
        int operationPriority = getOperationPriority(operator);

        int operationPriorityNow = getOperationPriority(NowOperator);

        return Integer.compare(operationPriorityNow, operationPriority);

    }

}
