package controller;

import constant.MenuType;
import io.CalculatorInput;
import io.CalculatorOutput;
import model.calculation.Calculation;
import model.converter.Converter;
import model.vo.Expression;
import model.vo.Menu;

import java.util.List;

public class CalculatorController implements Runnable {
    private static final String INVALID_MENU = "올바르지 않은 값입니다.";
    private final CalculatorInput input;
    private final CalculatorOutput output;
    private final Converter converter;
    private final Calculation calculation;

    public CalculatorController(CalculatorInput input, CalculatorOutput output, Converter converter, Calculation calculation) {
        this.input = input;
        this.output = output;
        this.converter = converter;
        this.calculation = calculation;
    }

    @Override
    public void run() {
        while (true) {
            output.printMenuMessage();
            selectMenu(input.menuInput());
        }
    }

    private void selectMenu(Menu menu) {
        MenuType menuType = MenuType.findMenuType(menu.getMenu());
        switch (menuType) {
            case CHECK_DATA -> runRecordLogic();
            case CALCULATION -> runCalculationLogic();
            default -> throw new IllegalArgumentException(INVALID_MENU);
        }
    }

    private void runRecordLogic() {
    }

    private void runCalculationLogic() {
        Expression expression = input.expressionInput();
        List<String> postfixExpression = converter.covert(expression);
        int result = calculation.calculate(postfixExpression);
        output.printExpression(result);
    }
}
