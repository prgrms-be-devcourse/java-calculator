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
        } else {
            // case2 = 계산 값을 출력해 준다.
            int index = 0;

            while (index < inputArr.length - 1) {
                String one = inputArr[index];
                String operation = inputArr[index + 1];
                String two = inputArr[index + 2];

                // + - 인 경우
                if (isPlusAndMius(operation)) {
                    lastList.add(one);
                    lastList.add(operation);
                } else {
                    // 곱하기인 경우
                    if (operation.equals("*")) {
                        inputArr[index + 2] = String.valueOf(Double.valueOf(one) * Double.valueOf(two));
                    } else if (operation.equals("/")) {
                        {
                            if (two.equals("0")) {
                                return null; // 0으로 나누는 경우 예외처리
                            }

                            inputArr[index + 2] = String.valueOf(Double.valueOf(one) / Double.valueOf(two));
                        }
                    }
                }
                index += 2;
            }

            lastList.add(inputArr[inputArr.length - 1]);

            // 최종 + - 로만 이루어진 lastList을 통해 값을 구한다
            Double result = Double.valueOf(lastList.get(0));

            for (int i = 1; i < lastList.size(); i += 2) {
                if (lastList.get(i).equals("+")) {
                    result += Double.valueOf(lastList.get(i + 1));
                } else if (lastList.get(i).equals("-")) {
                    result -= Double.valueOf(lastList.get(i + 1));
                }
            }

            // 소수 둘째자리까지 반올림
            try {
                result = Math.round((result * 100)) / 100.0;
            } catch (ArithmeticException e) {
                result = Double.valueOf(0);
            }
            return result;
        }
    }

    private boolean isPlusAndMius(String input) {
        if (input.equals("+") | input.equals("-")) {
            return true;
        } else {
            return false;
        }
    }
}