package com.devcourse.calc.converter;

import com.devcourse.calc.model.Operand;
import com.devcourse.calc.model.Operator;
import com.devcourse.calc.model.Token;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ConverterNoBracketTest {
    final Converter converter = new ConverterNoBracket();

    @Test
    @DisplayName("중위 표현식을 문자 단위로 나누어 후위 표현식으로 변경한다")
    void convertFormula() {
        List<Token> result = converter.convertFormula("1 + 2 - 3");

        assertThat(result.size()).isEqualTo(5);
        assertThat(result.get(0)).isEqualTo(new Operand(1));
        assertThat(result.get(1)).isEqualTo(new Operand(2));
        assertThat(result.get(2)).isEqualTo(Operator.PLUS);
        assertThat(result.get(3)).isEqualTo(new Operand(3));
        assertThat(result.get(4)).isEqualTo(Operator.MINUS);
    }

    @Test
    @DisplayName("중위 표현식을 문자 단위로 나누어 후위 표현식으로 변경한다 - 우선순위 적용")
    void convertFormulaPriority() {
        List<Token> result = converter.convertFormula("1 + 2 * 3");

        assertThat(result.size()).isEqualTo(5);
        assertThat(result.get(0)).isEqualTo(new Operand(1));
        assertThat(result.get(1)).isEqualTo(new Operand(2));
        assertThat(result.get(2)).isEqualTo(new Operand(3));
        assertThat(result.get(3)).isEqualTo(Operator.MULTIPLE);
        assertThat(result.get(4)).isEqualTo(Operator.PLUS);
    }
}