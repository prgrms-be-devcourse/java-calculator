package com.programmers.io;

import com.programmers.model.Expression;

import java.util.List;

public interface Output {
    void printAllExpressions(List<Expression> expressions);
    void printCalculatedNumber(double num);
    void printChooseWrongNumber();
}
