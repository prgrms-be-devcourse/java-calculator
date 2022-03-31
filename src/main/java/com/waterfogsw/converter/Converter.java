package com.waterfogsw.converter;

import com.waterfogsw.exception.NotExistsOperator;

import java.util.List;

public interface Converter {
    List<String> convert(List<String> infixExpr) throws NotExistsOperator;
}
