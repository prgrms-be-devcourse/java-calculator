package com.programmers.calculator.domain.component;

import com.programmers.calculator.domain.vo.CalculationResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class PostfixEvaluatorTest {

    @DisplayName("후위표기식의 계산이 잘 되는지 확인")
    @Test
    void right_convert_postfix () {

        // given
        PostfixEvaluator postfixEvaluator = new PostfixEvaluator();
        List<String> postfix = List.of("1", "2", "4", "*", "6", "*", "+");

        // when
        CalculationResult result = postfixEvaluator.evaluate(postfix);

        // then
        Assertions.assertThat(result.getValue()).isEqualTo(new BigDecimal(49));
    }

}