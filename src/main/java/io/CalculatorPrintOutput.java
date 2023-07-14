package io;

import model.entity.Calculator;
import model.vo.CalculationResult;

public class CalculatorPrintOutput implements CalculatorOutput {
    private static final String MENU_INIT_MESSAGE = "1. 조회\n2. 계산\n\n선택 : ";
    private static final String SELECT_OTHER_BUTTON = "1번 또는 2번만 눌럿!!";
    private static final String RECORD_MESSAGE = "%s = %d\n";

    @Override
    public void printMenuMessage() {
        System.out.print(MENU_INIT_MESSAGE);
    }

    @Override
    public void printSelectOtherMenu() {
        System.out.println(SELECT_OTHER_BUTTON);
    }

    @Override
    public void printExpression(CalculationResult expression) {
        System.out.println(expression.getCalculationResult());
    }

    @Override
    public void printRecords(Calculator calculator) {
        System.out.printf(RECORD_MESSAGE, calculator.getExpression(),
                calculator.getCalculationResult());
    }
}
