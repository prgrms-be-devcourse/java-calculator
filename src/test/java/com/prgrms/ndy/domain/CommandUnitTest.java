package com.prgrms.ndy.domain;

import com.prgrms.ndy.parsor.RegexParser;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandUnitTest {

    Offset<Double> OFFSET = Offset.offset(0.000_001);

    @ParameterizedTest
    @CsvSource(value = {
            "1+2+3+4,                   10",
            "1+2*3+4,                   11",
            "23*5/2+4*6,                81.5",
            "970821*970821,             942493414041",
            "0.980821*970821,           952201.624041",
            "-10+200*8.54--20/7,        1700.85714286",
            "-10-28.2*2.78-10.6/2,      -93.696",
            "-123.234*90-99832.0-8974,  -119897.06"
    })
    void proc_매서드가_잘동작한다(String expr, double expectedResult) {
        CommandUnit commandUnit = new RegexParser().parseLogic(expr);
        Double actualResult = commandUnit.proc();

        assertThat(actualResult).isCloseTo(expectedResult,OFFSET);
    }

    @Test
    void 영으로_나누면_예외를_던진다(){
        CommandUnit commandUnit = new RegexParser().parseLogic("1/0");
        assertThatThrownBy(() -> commandUnit.proc())
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("/ by zero");
    }
}