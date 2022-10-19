package me.programmers.calculator.engine.excpetion;

import me.programmers.calculator.engine.Operator;

public class Validator {

    public void problemValidate(String problem) throws Exception {
        // 계산식이 비었을 경우
        if (problem.isEmpty()) {
            throw new InputException("계산식이 비었습니다.");
        }

        // 계산식 맨 앞과 맨 뒤에 연산자가 있는 경우
        if (Operator.isOperator(problem.charAt(0)) ||
                Operator.isOperator(problem.charAt(problem.length() - 1))) {
            throw new InputException("계산식을 잘못 입력했습니다.");
        }

        // 계산식에 잘못된 연산자가 있는 경우
        for (char c : problem.toCharArray()) {
            if (!Character.isDigit(c) && !Operator.isOperator(c)) {
                throw new InputException("잘못된 연산 기호를 입력했습니다.");
            }
        }

        // 연산자가 두개 연속 나오는 경우
        for (int i = 0; i<= problem.length() - 1; i++) {
            if (!Character.isDigit(problem.charAt(i)) && !Character.isDigit(problem.charAt(i + 1))) {
                throw new InputException("연산 기호를 두 개 연속 입력했습니다.");
            }
        }
    }

}
