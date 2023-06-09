package com.programmers.junho.view;

import java.util.List;

public class PrintStreamOutputView implements OutputView {

    public static final String CHOICE_MESSAGE = "1. 조회\n" + "2. 계산";

    @Override
    public void printChoiceMessage() {
        System.out.println(CHOICE_MESSAGE);
    }

    @Override
    public void printExpressions(List<String> expressions) {
        validateIfIsEmpty(expressions);
        expressions.forEach(System.out::println);
    }

    private void validateIfIsEmpty(List<String> expressions) {
        if (expressions.isEmpty()) {
            System.out.println("계산 값이 존재하지 않습니다.");
        }
    }

    @Override
    public void printCalculatedResult(double result) {
        System.out.println(result);
    }
}
