package com.programmers.calculator.domain.core;

import com.programmers.calculator.domain.component.Evaluator;
import com.programmers.calculator.domain.component.NotationConverter;
import com.programmers.calculator.domain.component.PostfixConverter;
import com.programmers.calculator.domain.component.PostfixEvaluator;
import com.programmers.calculator.domain.vo.CalculationResult;
import com.programmers.calculator.domain.vo.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class FourArithmeticCalculatorTest {

    NotationConverter converter = new PostfixConverter();
    Evaluator evaluator = new PostfixEvaluator();
    FourArithmeticCalculator calculator = new FourArithmeticCalculator(converter, evaluator);

    @DisplayName("사칙연산 계산기의 계산이 잘 되는지 확인")
    @ParameterizedTest
    @CsvSource({
            "1 + 5 * 3 - 8, 8",
            "1 + 2 * 9 - 6, 13"
    })
    void right_calculate(String inputExpression, BigDecimal expectedResult) {

        // given
        Expression expression = new Expression(inputExpression);

        // when
        CalculationResult result = calculator.calculate(expression);

        // then
        assertThat(result.getValue()).isEqualTo(expectedResult);

    }

}