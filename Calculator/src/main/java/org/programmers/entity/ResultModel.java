package org.programmers.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * ResultModel에서 expressionId값을 관리하기 위해
 * AtomicLong.incrementAndGet()메서드를 활용했습니다.
 * EqualsAndHashCode의 구현을 어노테이션으로 대체했습니다.
 */
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
