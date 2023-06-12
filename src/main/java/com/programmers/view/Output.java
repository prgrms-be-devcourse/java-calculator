package com.programmers.view;

import com.programmers.domain.Menu;
import com.programmers.dto.CalculatorDto;

import java.util.List;

/**
 * 출력
 */
public class Output {
    private static final String FINISHMESSAGE = "계산기를 종료합니다.";

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

    //조회 출력
    public static void printHistories(List<CalculatorDto> dtoList) {
        StringBuilder sb = new StringBuilder();
        for (CalculatorDto dto : dtoList) {
            sb.append(dto.getExpression());
            sb.append(" = ");
            sb.append(dto.getAnswer());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}