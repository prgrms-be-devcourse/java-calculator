package com.programmers.view;

import com.programmers.domain.Menu;
import com.programmers.model.ExpressionResult;
import com.programmers.error.ConsoleMessage;

import java.util.List;

/**
 * 출력
 */
public class Output {

    public static void printMenu() {
        for (Menu menu : Menu.values()) {
            System.out.println(String.format("%d. %s", menu.getNum(), menu.getName()));
        }
        System.out.print("선택 : ");
    }


    //계산 후 결과 출력
    public static void printResult(int result) {
        System.out.println(result + "\n");
    }

    public static void printMessage(ConsoleMessage message){
        System.out.println(message.getMessage());
    }

    public static void printNewLine(){
        System.out.println();
    }

    //조회 출력
    public static void printHistories(List<ExpressionResult> dtoList) {
        StringBuilder sb = new StringBuilder();
        for (ExpressionResult dto : dtoList) {
            sb.append(dto.getExpression());
            sb.append(" = ");
            sb.append(dto.getAnswer());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
