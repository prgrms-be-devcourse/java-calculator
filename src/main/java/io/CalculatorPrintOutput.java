package io;

public class CalculatorPrintOutput implements CalculatorOutput{
    private static final String BUTTON_INIT_MESSAGE = "1. 조회\n2. 계산";
    private static final String BUTTON_CHOICE_MESSAGE = "선택 : ";
    private static final String RECORD_MESSAGE = "%s = %d";

    @Override
    public void printButtonMessage() {
        System.out.println(BUTTON_INIT_MESSAGE);
        System.out.print(BUTTON_CHOICE_MESSAGE);
    }

    @Override
    public void printResult(int result) {
        System.out.println(result);
    }

    @Override
    public void printRecords(String record, int result) {
        System.out.printf(RECORD_MESSAGE, record, result);
    }
}
