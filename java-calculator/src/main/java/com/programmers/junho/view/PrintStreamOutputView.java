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
        expressions.forEach(System.out::println);
    }

    @Override
    public void printCalculatedResult(int result) {
        System.out.println(result);
    }
}
