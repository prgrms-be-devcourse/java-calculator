package com.programmers.service;

import java.util.ArrayList;
import java.util.List;

public class CalculationService {

    List<String> lastList;

    public Double calculate(String input) {

        lastList = new ArrayList<>();
        String[] inputArr = input.split(" ");

        // case1 = 숫자 1개만 입력한 경우
        if (inputArr.length == 1) {
            return Double.valueOf(inputArr[0]);
        }

        // case2 = 계산 값을 출력해 준다.
        int index = 0;

        while (index < inputArr.length - 1) {
            String valueBeforeOperation = inputArr[index];
            String operation = inputArr[index + 1];
            String valueAfterOperation = inputArr[index + 2];

            // + - 인 경우
            if (isPlusAndMius(operation)) {
                plusOrMinusOperation(valueBeforeOperation, operation);
            } else {
                // 곱하기인 경우
                multiplyOperation(inputArr, index, valueBeforeOperation, operation, valueAfterOperation);
                // 나누기인 경우
                divideOperation(inputArr, index, valueBeforeOperation, operation, valueAfterOperation);
            }
            index += 2;
        }

        lastList.add(inputArr[inputArr.length - 1]);

        // 최종 + - 로만 이루어진 lastList을 통해 값을 구한다
        // 첫 값을 집어넣는다.
        Double result = Double.valueOf(lastList.get(0));

        // 리스트를 돌면서 값을 차례차례 계산한다.
        result = calculateList(result);

        // 소수 둘째자리까지 반올림
        result = SecondDecimal(result);

        return result;

    }

    private void divideOperation(String[] inputArr, int index, String valueBeforeOperation, String operation, String valueAfterOperation) {
        // 나누기 연산자일때 계산
        if (operation.equals("/")) {
            // 0 으로 나눈경우 예외처리
            if (valueAfterOperation.equals("0")) {
                throw new IllegalArgumentException("divide by zero");
            }

            Double divideValue = Double.valueOf(valueBeforeOperation) / Double.valueOf(valueAfterOperation);
            inputArr[index + 2] = String.valueOf(divideValue);
        }
    }

    private void multiplyOperation(String[] inputArr, int index, String valueBeforeOperation, String operation, String valueAfterOperation) {
        // 곱하기 연산자일때 계산
        if (operation.equals("*")) {
            Double multiplyValue = Double.valueOf(valueBeforeOperation) * Double.valueOf(valueAfterOperation);
            inputArr[index + 2] = String.valueOf(multiplyValue);
        }
    }

    private Double SecondDecimal(Double result) {
        // 소수 둘째자리까지 출력
        try {
            result = Math.round((result * 100)) / 100.0;
        } catch (ArithmeticException e) {
            result = Double.valueOf(0);
        }
        return result;
    }

    private Double calculateList(Double result) {
        // 최종 값을 계산하기 위해 List 를 돌면서 연산자 계산값을 result 에 담는다.
        for (int i = 1; i < lastList.size(); i += 2) {
            if (lastList.get(i).equals("+")) {
                result += Double.valueOf(lastList.get(i + 1));
            } else if (lastList.get(i).equals("-")) {
                result -= Double.valueOf(lastList.get(i + 1));
            }
        }
        return result;
    }

    private void plusOrMinusOperation(String valueBeforeOperation, String operation) {
        // + 혹은 - 연산자인 경우
        lastList.add(valueBeforeOperation);
        lastList.add(operation);
    }

    private boolean isPlusAndMius(String input) {
        // +,- 연산자인지 아닌지 판단
        if (input.equals("+") | input.equals("-")) {
            return true;
        } else {
            return false;
        }
    }
}