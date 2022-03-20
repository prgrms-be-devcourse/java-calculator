package com.prgrms.ndy.domain;

import com.prgrms.ndy.parsor.RegexParser;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CommandUnitTest {

    Offset<Double> OFFSET = Offset.offset(0.000_001);

    @ParameterizedTest
    @CsvSource(value = {
            "-1+-2,              -3",
            "-1--2,              1",
            "-1*-2,              2",
            "-1/-2,              0.5",

            "-1/-2+-1+-2,        -2.5",
            "-1/-2+-1--2,        1.5",
            "-1/-2+-1*-2,        2.5",
            "-1/-2+-1/-2,        1",

            "-1/-2--1+-2,        -0.5",
            "-1/-2--1--2,        3.5",
            "-1/-2--1*-2,        -1.5",
            "-1/-2--1/-2,        0",

            "-1/-2*-1+-2,        -2.5",
            "-1/-2*-1--2,        1.5",
            "-1/-2*-1*-2,        1",
            "-1/-2*-1/-2,        0.25",

            "-1/-2/-1+-2,        -2.5",
            "-1/-2/-1--2,        1.5",
            "-1/-2/-1*-2,        1",
            "-1/-2/-1/-2,        0.25",

            "1+2+3+4,            10",
            "1+2*3+4,            11",
            "23*5/2+4*6,         81.5",
            "-10+200*8.54--20/7, 1700.85714286",

            "-10-28.2*2.78-10.6/2, -93.696",
            "-123.234*90-99832.0-8974, -119897.06",
            "970821*970821, 942493414041",
            "0.980821*970821, 952201.624041"
    })
    void proc_매서드가_잘동작한다(String expr, double expectedResult) {
        CommandUnit commandUnit = new RegexParser().parseLogic(expr);
        Double actualResult = commandUnit.proc();

        assertThat(actualResult).isCloseTo(expectedResult,OFFSET);
    }
}