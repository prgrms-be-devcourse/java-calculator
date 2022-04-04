package calculator.module.validator;

import calculator.model.expression.Expression;
import calculator.module.validator.exception.InvalidExpressionException;

public interface ExpressionValidator {
    void validateExpression(Expression expression) throws InvalidExpressionException;
}
