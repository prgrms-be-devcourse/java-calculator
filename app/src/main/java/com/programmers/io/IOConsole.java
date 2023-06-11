package com.programmers.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOConsole {
    // 사용자에게 보여주는 메뉴 메시지
    private static final String HISTORY_OPTION_MESSAGE = "1. 조회";
    private static final String CALCULATE_OPTION_MESSAGE = "2. 계산";
    private static final String USER_CHOICE_MESSAGE = "선택 : ";
    /**
     * 계산기의 선택 메뉴를 출력하는 함수
     */
    public void printMenu() {
        System.out.println(HISTORY_OPTION_MESSAGE);
        System.out.println(CALCULATE_OPTION_MESSAGE);
        System.out.println();
    }

    /**
     * 사용자의 선택을 받아 반환하는 함수
     *
     * @return
     * @throws IOException
     */
    public String getOption() throws IOException {
        System.out.print(USER_CHOICE_MESSAGE);
        String expression = br.readLine();
        System.out.println();

        return expression;
    }
}