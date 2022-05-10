package com.programmers.java.calculation.parse;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class ValidationTest {

    Validation validation = new ValidationAddDecimalImpl();

    @Test
    public void validate() throws Exception {

        String input1 = "24+12/5-3*2";
        String input2 = "24+12/-5-3*2";
        String input3 = "24+12/+5-3*2";
        String input4 = "24+12//5-3*2";
        String input5 = "24+12/*5-3*2";

        boolean result1 = validation.validationTotal(input1);
        boolean result2 = validation.validationTotal(input2);
        boolean result3 = validation.validationTotal(input3);
        boolean result4 = validation.validationTotal(input4);
        boolean result5 = validation.validationTotal(input5);

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

        boolean result1 = validation.validationTotal(input1);
        boolean result2 = validation.validationTotal(input2);
        boolean result3 = validation.validationTotal(input3);
        boolean result4 = validation.validationTotal(input4);
        boolean result5 = validation.validationTotal(input5);

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

        boolean result1 = validation.validationTotal(input1);
        boolean result2 = validation.validationTotal(input2);
        boolean result3 = validation.validationTotal(input3);
        boolean result4 = validation.validationTotal(input4);
        boolean result5 = validation.validationTotal(input5);

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
        assertThat(result3).isFalse();
        assertThat(result4).isFalse();
        assertThat(result5).isFalse();

    }

    @Test
    public void validationTotal() throws Exception {

        Validation validation = new ValidationAddDecimalImpl();
        String input1 = "1+2+4+5+1";
        String input2 = "1a+2+4+5+1";
        boolean result1 = validation.validationTotal(input1);
        boolean result2 = validation.validationTotal(input2);

        assertThat(result1).isTrue();
        assertThat(result2).isFalse();

    }


}