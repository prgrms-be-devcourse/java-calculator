package com.programmers.view;

import com.programmers.model.CalculationResult;

import java.util.List;

public class Console {
    private final Input input;
    private final Output output;

    private static final String VIEW_MESSAGE = "1. 조회";
    private static final String CALCULATION_MESSAGE = "2. 계산";
    private static final String EXITING_MESSAGE = "3. 종료";
    private static final String CHOICE = "선택 : ";

    public Console(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public String inputMenu() {
        System.out.println(VIEW_MESSAGE);
        System.out.println(CALCULATION_MESSAGE);
        System.out.println(EXITING_MESSAGE);
        System.out.print(CHOICE);
        return input.read();
    }

    public String inputFormula() {
        return input.read();
    }

    public void printList(List<CalculationResult> record) {
        System.out.println();
        record.forEach(System.out::println);
    }

    public void print(String message) {
        System.out.println(message);
        System.out.println();
    }

    public void print(long result) {
        System.out.println(result);
        System.out.println();
    }
}

