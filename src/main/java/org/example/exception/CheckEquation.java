package org.example.exception;

import java.util.Optional;

public class CheckEquation {
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
            }else {
                preStr = Optional.ofNullable(str);
            }
        }
        return true;
    }

    private static boolean isOperator(String str) {
        return str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/");
    }
}
