package calculator.model.operator;

import calculator.module.validator.exception.InvalidTokenException;

public interface OperatorFactory {
    Operator makeOperator(String operatorSymbol) throws InvalidTokenException;
}
