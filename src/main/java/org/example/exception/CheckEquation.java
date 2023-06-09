package org.example.exception;

import java.util.Optional;

public class CheckEquation {

//    입력값의 첫번째와 마지막이 연산자인 경우, 연산자가 연속으로 나오는 경우,
//    0으로 나누는 경우 예외처리
    public static boolean validateEquation(String input){
        String[] strArr = input.split(" ");
        if (isOperator(strArr[0])){
            return false;
        } else if (isOperator(strArr[strArr.length-1])){
            return false;
        }

        Optional<String> preStr = Optional.empty();
        for (String str : strArr){
            if (preStr.isEmpty()){
                preStr = Optional.ofNullable(str);
            }else if (isOperator(preStr.get()) && isOperator(str)){
                return false;
            } else if (preStr.get().equals("/") && str.equals("0")) {
                return false;
            } else {
                preStr = Optional.ofNullable(str);
            }
        }
        return true;
    }

    private static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}
