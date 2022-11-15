package com.programmers.java.engine.calculator;

import com.programmers.java.engine.model.Expression;

public interface Calculator {
    static <T extends Number> Number cast(Number number, Class<T> type) {
        if (type == Short.class) return number.shortValue();
        if (type == Integer.class) return number.intValue();
        if (type == Long.class) return number.longValue();
        if (type == Float.class) return number.floatValue();
        if (type == Double.class) return number.doubleValue();
        if (type == Byte.class) return number.byteValue();

        throw new ArithmeticException("설정된 타입으로 변환이 불가합니다.");
    }

    Number calculate(Expression expression);

}
