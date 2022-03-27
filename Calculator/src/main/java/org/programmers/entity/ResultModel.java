package org.programmers.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@EqualsAndHashCode
@Getter
public class ResultModel {
    private static final AtomicLong count = new AtomicLong(0L);
    private final long expressionId;
    private final String inputExpression;
    private final double calculationResult;

    public ResultModel(String inputExpression, double calculationResult) {
        this.expressionId = count.incrementAndGet();
        this.inputExpression = inputExpression;
        this.calculationResult = calculationResult;
    }

    @Override
    public String toString() {
        return inputExpression + " = " + calculationResult;
    }
}
