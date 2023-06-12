package com.bona.javacalculator.service;

import java.util.Optional;


public class ValidateService {

    public Optional<String> validate(String input) {
        String[] inputString = input.split("");

        if (inputString.length < 3) {
            return Optional.empty();
        }


        boolean isDivision = false;
        for (int i = 0; i < inputString.length; i++) {
            if (i % 2 == 1) { // 홀수 자리일 경우 연산자여야 함.
                if(!CheckService.isOperator(inputString[i])){
                    return Optional.empty();
                }
                // / 일 경우 0 나누는경울 처리
                if(inputString[i].equals("/")){
                    isDivision = true;
                }
                // 숫자 validate
            } else if (!isValidNumber(inputString[i], isDivision)) {
                return Optional.empty();
            }
        }
        //마지막 자리가 숫자인지
        if(!CheckService.isNumber(inputString[inputString.length-1])){
            return Optional.empty();
        }
        return Optional.of(input);
    }

    private boolean isValidNumber(String s, boolean isDivision) {
        //숫자 인지
        if(!CheckService.isNumber(s)){
            return false;
        }
        // 0이고 앞서 나온 연산자가 / 라면 false
        if(s.equals("0") && isDivision){
            return false;
        }
        return true;
    }






}
