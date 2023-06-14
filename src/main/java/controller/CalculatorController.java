package controller;

import constant.MenuType;
import io.CalculatorInput;
import io.CalculatorOutput;
import model.calculation.Calculation;
import model.converter.Converter;
import model.vo.CalculationResult;
import model.vo.Expression;
import model.vo.Menu;

import java.util.List;

public class CalculatorController {
    public static final String INVALID_MENU = "올바르지 않은 값입니다.";
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

    public void runProgram() {
        while (true) {
            output.printMenuMessage();
            selectCalculatorFunction(input.menuInput());
        }
    }

    private void selectCalculatorFunction(Menu menu) {
        MenuType menuType = MenuType.findMenuType(menu.getMenu());
        switch (menuType) {
            case INQUIRY -> printExpressions();
            case CALCULATION -> {
                Expression expression = input.expressionInput();
                CalculationResult calculationResult = getCalculationResult(expression);
                output.printExpression(calculationResult);
            }
            default -> output.printSelectOtherMenu();
        }
    }

    private void printExpressions() {
    }

    private CalculationResult getCalculationResult(Expression expression) {
        List<String> postfixExpression = converter.convert(expression);
        CalculationResult calculationResult = calculation.calculate(postfixExpression);
        return calculationResult;
    }
}
