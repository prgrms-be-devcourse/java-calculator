package org.example.util;

import org.example.exception.BadEquationException;

import java.util.Optional;

public class CheckEquation {

    public static void validate(String input){
        String[] formatedStr = InputStringFormating.formating(input);
        if (!validateEquation(formatedStr)) throw new BadEquationException();
    }

//    입력값의 첫번째와 마지막이 연산자인 경우, 연산자가 연속으로 나오는 경우,
//    0으로 나누는 경우 예외처리
    private static boolean validateEquation(String[] inputStrArr){
        if (Operator.isOperator(inputStrArr[0])) return false;
        if (Operator.isOperator(inputStrArr[inputStrArr.length-1])) return false;

        Optional<String> preStr = Optional.empty();
        for (String str : inputStrArr){
            if (!str.matches("\\d+") && !Operator.isOperator(str)) return false;
            else if (preStr.isEmpty()) preStr = Optional.ofNullable(str);
            else if (Operator.isOperator(preStr.get()) && Operator.isOperator(str)) return false;
            else if (preStr.get().equals("/") && str.equals("0")) return false;
            else preStr = Optional.ofNullable(str);
        }
        return true;
    }
}
