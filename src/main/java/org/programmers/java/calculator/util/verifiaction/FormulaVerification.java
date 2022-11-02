package org.programmers.java.calculator.util.verifiaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class FormulaVerification {

    public void formulaVerifiaction(List<String> tokens) {

        List<String> numbers = new ArrayList<>();
        List<String> operators = new ArrayList<>();

        for (int i = 0; i < tokens.size(); i++) {
            if (i % 2 == 0) {
                numbers.add(tokens.get(i));
            } else {
                operators.add(tokens.get(i));
            }
        }

        if (numbers.size() != operators.size() + 1) {
            throw new IllegalArgumentException("잘못된 수식입니다.");
        }

        numberVerification(numbers);
        operatorVerification(operators);
    }

    private void numberVerification(List<String> numbers) {
        Pattern numberPattern = Pattern.compile("[0-9]");
        numbers.stream().filter(token -> !numberPattern.matcher(token).matches()).findAny().ifPresent(
                t -> {
                    throw new IllegalArgumentException("잘못된 숫자가 입력되었습니다.");
                }
        );
    }

    private void operatorVerification(List<String> operators) {
        Pattern operatorPattern = Pattern.compile("[+-/*]");
        operators.stream().filter(token -> !operatorPattern.matcher(token).matches()).findAny().ifPresent(
                t->{
                    throw new IllegalArgumentException("잘못된 연산자가 입력되었습니다.");
                }
        );
    }

    private void blankVerification(String input) {
        Pattern blankPattern = Pattern.compile("[+-/*][0-9]");
        List<String> token = Arrays.asList(input.split(""));

        for (int i = 0; i < token.size(); i++) {
            if (i % 2 == 0) {
                if (!blankPattern.matcher(token.get(i)).matches()) {

                }
            } else {
                if (!token.get(i).isBlank()) {
                    throw new IllegalArgumentException("잘못된 공식이 입력되었습니다.");
                }
            }
        }
    }
}
