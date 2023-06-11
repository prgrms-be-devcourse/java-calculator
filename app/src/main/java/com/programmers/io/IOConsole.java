package com.programmers.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOConsole {
    // 사용자에게 보여주는 메뉴 메시지
    private static final String HISTORY_OPTION_MESSAGE = "1. 조회";
    private static final String CALCULATE_OPTION_MESSAGE = "2. 계산";
    private static final String USER_CHOICE_MESSAGE = "선택 : ";

    // 오류 발생 메시지
    private static final String WRONG_INPUT_MESSAGE = "계산기에서 지원하지 않는 입력입니다.";
    private static final String WRONG_OPTION_MESSAGE = "계산기에서 지원하지 않는 옵션입니다.";
    private static final String SHUTDOWN_MESSAGE = "계산기를 종료합니다.";

    // 사용자의 입력을 검증하는 regex. 사칙연산자와 숫자, 공백 문자열을 허용한다.
    private static final String INPUT_REGEX = "^[\\d\\+\\-\\*/\\(\\)\\s]+$";

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

    /**
     * 사용자의 입력을 받아 반환하는 함수
     *
     * @return 사용자가 입력한 문자열
     * @throws IOException
     */
    public String getInput() throws IOException {
        return br.readLine();
    }

    /**
     * 잘못된 선택 입력이 들어왔을 때 처리하는 메소드
     *
     * @throws IOException
     */
    public void handleWrongInput() throws IOException {
        System.out.println(WRONG_OPTION_MESSAGE);
        System.out.println(SHUTDOWN_MESSAGE);
        br.close();
    }

    /**
     * 계산의 결과를 출력하는 함수
     *
     * @param answer 계산의 결과
     */
    public void printAnswer(double answer) {
        System.out.printf("%.2f", answer);
        System.out.println();
        System.out.println();
    }

    /**
     * 문자열을 출력하는 함수
     *
     * @param s 문자열
     */
    public void print(String s) {
        System.out.println(s);
    }

    /**
     * 사용자의 input을 검증하는 메소드.
     *
     * @param inputExpression 사용자가 입력한 중위 표현식
     * @return true or false
     */
    public boolean validateInputExpression(String inputExpression) {
        if (!inputExpression.matches(INPUT_REGEX)) {
            System.out.println(WRONG_INPUT_MESSAGE + "\n");
            return false;
        }

        return true;
    }
}