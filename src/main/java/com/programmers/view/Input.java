package com.programmers.view;

import com.programmers.util.Validator;

import java.util.Scanner;

/**
 * 입력
 */

public class Input {
    private static final Scanner scanner = new Scanner(System.in);
    public static int inputMenu(){
        int menuNum;

        try{
            menuNum = Validator.checkInteger(scanner.nextLine());
        }catch(NumberFormatException e){
            System.out.print("\n정수가 아닙니다. 메뉴를 다시 입력해주세요\n선택 : ");
            return inputMenu(); //반복
        }

        System.out.println(); //공백

        if(!Validator.check123(menuNum)){
            System.out.print("없는 메뉴 입니다. 메뉴를 다시 입력해주세요\n선택 : ");
            inputMenu(); //반복
        }

        return menuNum;
    }

    public static String inputExpression(){
        //todo : StringConverter 이용
        String expression = scanner.nextLine();
        return expression;
    }
}
