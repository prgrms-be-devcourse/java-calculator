package com.prgrms.ndy.parsor;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

class RegexTest {

    @ParameterizedTest
    @CsvSource(value = {
            "1234",
            "9876",
            "1234.5",
            "987.44",
            "-123",
            "-1.5",
            "-1234456"
    })
    void 숫자_테스트(String number) {
        String pattern = "^-?\\d*\\.?\\d+$";
        assertThat(number.matches(pattern)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "+", "-", "*", "/"
    })
    void 연산자_테스트(String opCode) {
        String pattern = '^' + "[\\+\\-\\*\\/]" + '$';
        assertThat(opCode.matches(pattern)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-2+-1",
            "-2--1",
            "-2/-1",
            "-2*-1",
            "-2*16",
            "1+2+3+4+5",
            "4/2*4+10.7",
            "2.8*7.3-8+7.0+11",
            "-1-2-3--4-5-6--7"
    })
    void 연식식_정당성_검증_테스트(String expression) {
        String number = "-?\\d*\\.?\\d+";
        String pattern = "^" + number + "(" + "[\\+\\-\\*\\/]" + number + ")*$";  //pattern : "^((-?\\d*\\.?\\d+)[\\+\\-\\*\\/])+(-?\\d*\\.?\\d+)$"
        System.out.println("pattern = " + pattern);

        assertThat(expression.matches(pattern)).isTrue();
    }


    @ParameterizedTest
    @CsvSource(value = {                       //  -> ExpectedOut       || Split By
            "P-2*16,              2, 16",       //  -> -2,16             || *
            "P1+2+3+4+5,          5,  5",       //  -> 1,2,3,4,5         || + + + +
            "P4/2*4+10.7,         4,10.7",        // -> 4,2,4,10.7        || / * +
            "P-1-2-3/-4-5-6*-7,   7,  -7",       // -> -1,2,3,-4,5,6,-7  || - - / - - -
            "P2.8*7.3-8+7.0+11,   5,  11"       // -> 2.8,7.3,8,7.0,11 || * - + +
    })
    void 연산자와_숫자를_뽑아내자(String expression, int expectedNumberCount, String expectedLastNumber) {
        Pattern numberPattern = Pattern.compile("([P\\+\\-\\*\\/])(-?\\d*\\.?\\d+)");
        Matcher m = numberPattern.matcher(expression);
        m.results().forEach(
                match -> {
                    String operation = match.group(1);
                    String number = match.group(2);
                    System.out.printf("Operation : %s, Number : %s\n", operation, number);
                }
        );

        m = numberPattern.matcher(expression);
        int count = 0;
        String number = null;
        while(m.find()){
            count+=1;
            number = m.group(2);
        }
        assertThat(count).isEqualTo(expectedNumberCount);
        assertThat(number).isEqualTo(expectedLastNumber);
    }
}
