package org.programmers.domain.converter;

import org.programmers.domain.expression.ExpressionParam;

public interface Converter {
    ExpressionParam convert(String expression);
}
