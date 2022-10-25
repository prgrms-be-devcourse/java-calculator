package calculator.engine.converter;

import calculator.engine.model.Expression;

public interface Converter {
    Expression toPostfix(Expression infix);
}
