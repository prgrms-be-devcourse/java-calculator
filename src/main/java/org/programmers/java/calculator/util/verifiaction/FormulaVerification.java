package org.programmers.java.calculator.util.verifiaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class FormulaVerification {

    public static void formulaVerifiaction(List<String> token) {
        List<String> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        for (int i = 0; i < token.size(); i++) {
            if (i % 2 == 0) {
                numbers.add(token.get(i));
            } else {
                operators.add(token.get(i));
            }
        }

        if (numbers.size() != operators.size() + 1) {
            throw new IllegalArgumentException("잘못된 수식입니다.");
        }

        numberVerification(numbers);
        operatorVerification(operators);
    }

    private static void numberVerification(List<String> numbers) {
        Pattern numberPattern = Pattern.compile("[0-9]");
        numbers.stream().filter(token -> !numberPattern.matcher(token).matches()).findAny().ifPresent(
                t -> {
                    throw new IllegalArgumentException("잘못된 숫자가 입력되었습니다.");
                }
        );
    }

    private static void operatorVerification(List<String> operators) {
        // ( +, -, *, / ) 이 친구들만 거르려고 합니다.
        Pattern operatorPattern = Pattern.compile("[+-/*]");
        operators.stream().filter(token -> !operatorPattern.matcher(token).matches()).findAny().ifPresent(
                t->{
                    throw new IllegalArgumentException("잘못된 연산자가 입력되었습니다.");
                }
        );
    }
}
