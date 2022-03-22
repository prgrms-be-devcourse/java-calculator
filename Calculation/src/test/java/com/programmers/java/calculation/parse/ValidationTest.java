package com.programmers.java.calculation.parse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class ValidationTest {

    Validation validation = new ValidationImpl();

    @Test
    public void validation() throws Exception {

        String[] input1 = {"24", "+", "12", "/", "5", "-", "3", "*", "2"};
        String[] input2 = {"24", "+", "12", "/", "+", "5", "-", "3", "*", "2"};
        boolean result1 = validation.validate(input1);
        boolean result2 = validation.validate(input2);

        Assertions.assertThat(result1).isTrue();
        Assertions.assertThat(result2).isFalse();



    }

}