package com.programmers.junho.view;

import java.util.List;

public class OutputView {

    public static void printExpressions(List<String> expressions) {
        expressions.forEach(System.out::println);
    }

    public static void printCalculatedResult(int result) {
        System.out.println(result);
    }
}
