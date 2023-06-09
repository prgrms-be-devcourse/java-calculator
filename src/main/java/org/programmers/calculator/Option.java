package org.programmers.calculator;

import java.util.Arrays;
import java.util.InputMismatchException;

public enum Option {
    QUERY(1),
    CALC(2),
    EXIT(0);

    private final int number;

    Option(int number) {
        this.number = number;
    }


    public static Option findByNumber(String num){
        for(Option option : Option.values()){
            if(option.number == Integer.parseInt(num)){
                return option;
            }
        }
        throw new InputMismatchException("올바른 번호를 입력해주세요. 1 : 조회 , 2 : 계산 , 0 : 종료");
    }
}