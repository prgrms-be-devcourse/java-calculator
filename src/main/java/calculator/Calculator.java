package calculator;

import calculator.model.Menu;
import calculator.model.CalculationResult;
import calculator.util.ExpressionConverter;
import calculator.io.Input;
import calculator.io.Output;
import calculator.model.BasicCalculator;
import calculator.repository.CalculationRepository;
import calculator.util.validator.CalculatorValidator;

import java.util.List;


public class Calculator implements Runnable {
    private final BasicCalculator calculator;
    private final ExpressionConverter expressionConverter;
    private final Input input;
    private final Output output;
    private final CalculationRepository calculationRepository;

    public static final String MENU_INPUT_ERROR = "메뉴가 올바르게 입력되지 않았습니다.";
    public static final String INVALID_INPUT_EXPRESSION = "올바른 수식 표현이 아닙니다.";
    public static final char REQUEST_EXIT = '0';
    public static final char REQUEST_VIEW_CALCULATION_RESULT = '1';
    public static final char REQUEST_CALCULATION = '2';
    public static final String CHOICE_PROMPT = "\n선택 : ";
    public static final int FIRST_INDEX = 0;

    public Calculator(BasicCalculator calculator, ExpressionConverter expressionConverter, Input input, Output output, CalculationRepository calculationRepository) {
        this.calculator = calculator;
        this.expressionConverter = expressionConverter;
        this.input = input;
        this.output = output;
        this.calculationRepository = calculationRepository;
    }


    @Override
    public void run() {
        boolean isProgramRunnable = true;
        while (isProgramRunnable) {
            output.putMenu();
            String inputMenu = input.getChoice(CHOICE_PROMPT);
            if (!Menu.isValidMenu(inputMenu)) {
                output.inputError(MENU_INPUT_ERROR);
                continue;
            }

            switch (inputMenu.charAt(FIRST_INDEX)) {
                case REQUEST_EXIT -> isProgramRunnable = false;
                case REQUEST_VIEW_CALCULATION_RESULT -> output.showCalculationResult(calculationRepository.findAll());
                case REQUEST_CALCULATION -> {
                    String expression = input.getExpression();
                    if (!CalculatorValidator.isValidExpression(expression)) {
                        output.inputError(INVALID_INPUT_EXPRESSION);
                        continue;
                    }
                    List<String> convertedExpression = expressionConverter.convert(expression);
                    Integer result = calculator.calculate(convertedExpression);
                    output.showResult(result.toString());
                    calculationRepository.save(new CalculationResult(expression, result));
                }
            }
        }
    }
}
