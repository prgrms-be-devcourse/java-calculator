package io;

import model.vo.CalculationResult;

public class CalculatorPrintOutput implements CalculatorOutput {
    private static final String MENU_INIT_MESSAGE = "1. 조회\n2. 계산\n\n선택 : ";
    private static final String RECORD_MESSAGE = "%s = %d\n";

    @Override
    public void printMenuMessage() {
        System.out.print(MENU_INIT_MESSAGE);
    }

    @Override
    public void printExpression(CalculationResult expression) {
        System.out.println(expression.getCalculationResult());
    }

    @Override
    public void printRecords(String record, int result) {
        System.out.printf(RECORD_MESSAGE, record, result);
    }
}
