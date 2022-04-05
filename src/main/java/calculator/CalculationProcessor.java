package calculator;

import calculator.model.expression.Expression;
import calculator.model.expression.ExpressionFactory;
import calculator.module.arithmetic.ArithmeticModule;
import calculator.module.history.CalculationHistory;
import calculator.module.history.CalculationHistoryManager;
import calculator.module.ui.UserInterface;
import calculator.module.validator.ExpressionValidator;
import calculator.module.validator.exception.InvalidExpressionException;

/*
 * 기능
 * 1. 문자열 수식 계산
 *    - 사용자에게 문자열 수식을 입력받음 -> UserInterface 클래스에 위임
 *    - 입력받은 문자열로 구성된 수식이 유효한 수식인지 검증 -> ExpressionValidator 클래스에 위임
 *    - 검증된 문자열 수식 계산 -> ArithmeticModule 클래스에 위임
 *    - 계산 이력을 저장 -> CalculationHistoryManager 클래스에 위임
* */

public class CalculationProcessor {
    private static final String CALCULATION_GUILD_MESSAGE = "계산 수식을 입력하세요. 연산자(괄호 포함)와 숫자는 반드시 공백으로 구분해주세요.";
    private final CalculationHistoryManager historyManager;
    private final UserInterface userInterface;
    private final ArithmeticModule arithmeticModule;
    private final ExpressionValidator expressionValidator;
    private final ExpressionFactory expressionFactory;

    public CalculationProcessor(CalculationHistoryManager calculationHistoryManager,
                                ArithmeticModule arithmeticModule,
                                UserInterface userInterface,
                                ExpressionValidator expressionValidator,
                                ExpressionFactory expressionFactory) {
        this.historyManager = calculationHistoryManager;
        this.arithmeticModule = arithmeticModule;
        this.expressionValidator = expressionValidator;
        this.userInterface = userInterface;
        this.expressionFactory = expressionFactory;
    }

    public void startCalculateProcess() {
        userInterface.printMessage(CALCULATION_GUILD_MESSAGE);
        String userInput = userInterface.inputString();
        try {
            Expression expression = expressionFactory.createExpression(userInput);
            expressionValidator.validateExpression(expression);
            Double calculationResult = arithmeticModule.calculate(expression);
            CalculationHistory newHistory = new CalculationHistory(userInput, calculationResult);
            historyManager.saveCalculationResultToHistory(userInput, newHistory);
            userInterface.printMessage(calculationResult.toString());
        } catch (InvalidExpressionException e) {
            userInterface.printMessage(e.getMessage());
        }
    }
}
