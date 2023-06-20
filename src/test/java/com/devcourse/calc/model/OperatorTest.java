package com.devcourse.calc.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.devcourse.calc.model.Operator.*;
import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {

    @Test
    @DisplayName("연산자 기호를 통해 연산자 객체를 찾아온다")
    void findOperator() {
        Operator plusOperator = Operator.find('+');
        assertThat(plusOperator).isEqualTo(PLUS);

        Operator minusOperator = Operator.find('-');
        assertThat(minusOperator).isEqualTo(MINUS);

        Operator multipleOperator = Operator.find('*');
        assertThat(multipleOperator).isEqualTo(MULTIPLE);

        Operator divideOperator = Operator.find('/');
        assertThat(divideOperator).isEqualTo(DIVISION);
    }
}