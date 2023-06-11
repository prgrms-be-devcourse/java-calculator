package com.programmers.util;

import com.programmers.view.Input;

public class Validator {

    //정수인지 판별
    public static int checkInteger(String data) {
        int num;
        try{
            return num = Integer.parseInt(data);
        }catch (NumberFormatException e){
            throw new NumberFormatException("정수가 아닙니다.");
        }
    }

    //1,2,3중 하나의 값을 가지는지 판별
    public static boolean check123(int menuNum) {
        if(menuNum>=0 && menuNum<=3) return true;
        else return false;
    }

    //식이 숫자와 사칙연산으로 이루어졌는지 확인
}
