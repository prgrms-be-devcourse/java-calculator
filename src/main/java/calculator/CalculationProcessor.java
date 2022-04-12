package calculator;

import calculator.model.expression.Expression;
import calculator.model.expression.ExpressionFactory;
import calculator.module.arithmetic.ArithmeticModule;
import calculator.module.validator.ExpressionValidator;
import calculator.module.validator.exception.InvalidExpressionException;

public class CalculationProcessor {
    private final ArithmeticModule arithmeticModule;
    private final ExpressionValidator expressionValidator;
    private final ExpressionFactory expressionFactory;

    public CalculationProcessor(ArithmeticModule arithmeticModule,
                                ExpressionValidator expressionValidator,
                                ExpressionFactory expressionFactory) {
        this.arithmeticModule = arithmeticModule;
        this.expressionValidator = expressionValidator;
        this.expressionFactory = expressionFactory;
    }

    public Double startCalculateProcess(String userInput) throws InvalidExpressionException{
        Expression expression = expressionFactory.createExpression(userInput);
        expressionValidator.validateExpression(expression);
        return arithmeticModule.calculate(expression);
    }
}
