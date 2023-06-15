package com.programmers.calculator.domain.core;

import com.programmers.calculator.domain.component.Converter;
import com.programmers.calculator.domain.component.Evaluator;
import com.programmers.calculator.domain.component.PostfixConverter;
import com.programmers.calculator.domain.component.PostfixEvaluator;
import com.programmers.calculator.domain.vo.CalculationResult;
import com.programmers.calculator.domain.vo.Expression;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class FourArithmeticCalculatorTest {

    Converter converter = new PostfixConverter();
    Evaluator evaluator = new PostfixEvaluator();
    FourArithmeticCalculator calculator = new FourArithmeticCalculator(converter, evaluator);

    @DisplayName("사칙연산 계산기의 계산이 잘 되는지 확인")
    @Test
    void right_calculate() {
        // given
        Expression expression = new Expression("1 + 5 * 3 - 8");

        // when
        CalculationResult result = calculator.calculate(expression);

        // then
        Assertions.assertThat(result.getValue()).isEqualTo(new BigDecimal(8));
    }

}