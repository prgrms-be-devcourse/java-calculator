package com.programmers.java.application.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static com.programmers.java.application.config.Constant.ADD_MINUS_OPERATOR_REGEX;
import static com.programmers.java.application.config.Constant.SPLIT_TOKENIZER_REGEX;

public class CalculatorUtils {
    public static String makeNonSpaceString(String input) {
        return input.replace(" ", "");
    }

    public static List<String> numberOperatorTokenizer(String str) {
        return Arrays.asList(str.split(SPLIT_TOKENIZER_REGEX));
    }

    public static boolean isMatchRegex(String token, String regex) {
        return Pattern.matches(regex, token);
    }

    // 연산자 우선순위 파악, 숫자 높을 수록 우선순위 높음
    public static Integer getRank(String token) {
        if (isMatchRegex(token, ADD_MINUS_OPERATOR_REGEX)) {
            return 1;
        } else {
            return 2;
        }
    }
}
