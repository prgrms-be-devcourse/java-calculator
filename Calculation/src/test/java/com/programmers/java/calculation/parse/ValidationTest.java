package com.programmers.java.calculation.parse;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ValidationTest {

    ValidationOp validation = new ValidationImpl();

    @Test
    public void validate() throws Exception {

        String input1 = "24+12/5-3*2";
        String input2 = "24+12/-5-3*2";
        String input3 = "24+12/+5-3*2";
        String input4 = "24+12//5-3*2";
        String input5 = "24+12/*5-3*2";

        boolean result1 = validation.validateContOp(input1);
        boolean result2 = validation.validateContOp(input2);
        boolean result3 = validation.validateContOp(input3);
        boolean result4 = validation.validateContOp(input4);
        boolean result5 = validation.validateContOp(input5);

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
        assertThat(result5).isFalse();
    }
    @Test
    public void validateFirstOp() throws Exception {
        String input1 = "24+12/5-3*2";
        String input2 = "+24+12/5-3*2";
        String input3 = "-24+12/5-3*2";
        String input4 = "*24+12/5-3*2";
        String input5 = "/24+12/5-3*2";

        boolean result1 = validation.validateFirstOp(input1);
        boolean result2 = validation.validateFirstOp(input2);
        boolean result3 = validation.validateFirstOp(input3);
        boolean result4 = validation.validateFirstOp(input4);
        boolean result5 = validation.validateFirstOp(input5);

        assertThat(result1).isTrue();
        assertThat(result2).isTrue();
        assertThat(result3).isTrue();
        assertThat(result4).isFalse();
        assertThat(result5).isFalse();

    }

    @Test
    public void validateLastOp() throws Exception {
        String input1 = "24+12/5-3*2";
        String input2 = "24+12/5-3*2-";
        String input3 = "24+12/5-3*2+";
        String input4 = "24+12/5-3*2*";
        String input5 = "24+12/5-3*2/";

        boolean result1 = validation.validateLastOp(input1);
        boolean result2 = validation.validateLastOp(input2);
        boolean result3 = validation.validateLastOp(input3);
        boolean result4 = validation.validateLastOp(input4);
        boolean result5 = validation.validateLastOp(input5);

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
        assertThat(result5).isFalse();

    }

    @Test
    public void validateString() throws Exception {

        ValidationString validation2 = new ValidationImpl();
        String input1 = "1+2+4+5+1";
        String input2 = "1a+2+4+5+1";
        boolean result1 = validation2.validateString(input1);
        boolean result2 = validation2.validateString(input2);

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();

    }


}