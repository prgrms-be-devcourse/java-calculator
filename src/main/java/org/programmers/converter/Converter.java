package org.programmers.converter;

import org.programmers.expression.ExpressionParam;

public interface Converter {

    ExpressionParam convert(String expression);
}
