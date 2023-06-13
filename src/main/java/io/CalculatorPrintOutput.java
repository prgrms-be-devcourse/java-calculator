package io;

public class CalculatorPrintOutput implements CalculatorOutput {
    private static final String BUTTON_INIT_MESSAGE = "1. 조회\n2. 계산\n\n선택 : ";
    private static final String RECORD_MESSAGE = "%s = %d\n";

    @Override
    public void printMenuMessage() {
        System.out.print(BUTTON_INIT_MESSAGE);
    }

    @Override
    public void printExpression(int expression) {
        System.out.println(expression);
    }

    @Override
    public void printRecords(String record, int result) {
        System.out.printf(RECORD_MESSAGE, record, result);
    }
}
