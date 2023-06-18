package com.programmers.calculator.domain.component;

import com.programmers.calculator.domain.vo.CalculationResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PostfixEvaluatorTest {

    PostfixEvaluator postfixEvaluator = new PostfixEvaluator();

    @DisplayName("후위표기식의 계산이 잘 되는지 확인")
    @Test
    void right_convert_postfix () {

        // given
        List<String> postfix = List.of("1", "2", "4", "*", "6", "*", "+");

        // when
        CalculationResult result = postfixEvaluator.evaluate(postfix);

        // then
        assertThat(result.getValue()).isEqualTo(new BigDecimal(49));
    }

    @DisplayName("잘못된 후위표기식이 예외를 던지는지 확인")
    @Test
    void throw_wrong_evaluate_postfix () {

        // given
        List<String> postfix = List.of("1", "+", "+");

        // then
        assertThatThrownBy(() -> postfixEvaluator.evaluate(postfix))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 수식입니다.");

    }

}