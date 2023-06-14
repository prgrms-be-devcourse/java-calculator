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
        output.print(VIEW_MESSAGE);
        output.print(CALCULATION_MESSAGE);
        output.print(EXITING_MESSAGE);
        System.out.print(CHOICE);
        return input.read();
    }

    public String inputFormula() {
        return input.read();
    }

    public void printList(List<CalculationResult> record) {
        output.print(record);
    }

    public void print(String message) {
        output.print(message);
    }

    public void print(long result) {
        output.print(result);
    }
}

