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


    /**
     * 음수기호('-') 와 빼기 ('-')가 겹친다.
     * 빼기 : 숫자 뒤에 나오는 경우
     */
    //TODO : 숫자 뽑아내기 구현
    @ParameterizedTest
    @CsvSource(value = {                       //  -> ExpectedOut       || Split By
            "-2*16,              2, -2",       //  -> -2,16             || *
            "1+2+3+4+5,          5,  1",       //  -> 1,2,3,4,5         || + + + +
            "4/2*4+10.7,         4,  4",        // -> 4,2,4,10.7        || / * +
            "-1-2-3/-4-5-6*-7,   7,  -1",       // -> -1,2,3,-4,5,6,-7  || - - / - - -
            "2.8*7.3-8+7.0+11,   5,  2.8"       // -> 2.8,7.3,8,7.0,11 || * - + +
    })
    void 연산식_연산자로_분리해서_숫자_뽑아내기(String expression, int expectedNumberCount, String expectedFirstNumber) {
        String s = "(\\+|(?!\\d*\\.?\\d+)-|\\*|/)";
        Pattern pattern = Pattern.compile(s);
        Matcher m = pattern.matcher(expression);
        String[] numbers = pattern.split(expression);
        for (String number : numbers) {
            System.out.println(number);
        }
    }


    @ParameterizedTest
    @CsvSource(value = {
            "-2+-1,             1",
            "-2--1,             1",
            "-2/-1,             1",
            "-2*-1,             1",
            "-2*16,             1",
            "1+2+3+4+5,         4",
            "4/2*4+10.7,        3",
            "2.8*7.3-8+7.0+11,  4",
            "-1-2-3--4-5-6--7,  6"

    })
    void 연산자를_뽑아내자(String expr, long expectedOpCount) {
        Pattern operatorPattern = Pattern.compile("(\\+|((\\d)\\-)|\\*|\\/)");
        Matcher m = operatorPattern.matcher(expr);
        assertThat(m.results().count()).isEqualTo(expectedOpCount);
    }

    private String extractOperator(Matcher m) {
        String group = m.group(1);
        return group.length() > 1 ? "-" : group;
    }
}
