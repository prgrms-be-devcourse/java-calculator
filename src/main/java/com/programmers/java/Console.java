package com.programmers.java;

import com.programmers.java.engine.Lobby;
import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console implements Output, Input {

    private final Scanner scanner = new Scanner(System.in);
    private final int ERROR_OPTION = -1;

    /* optionInput : prompt를 출력하고 정수를 입력 받는 메소드 */
    @Override
    public int optionInput(String prompt) {
        System.out.println(prompt);
        int userOption = ERROR_OPTION;
        try {
            userOption = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine(); //버퍼비우기
        }
        return userOption;
    }

    /* strInput : prompt를 출력하고 문자열 한줄을 입력 받는 메소드 */
    @Override
    public String strInput(String prompt) {
        System.out.println(prompt);
        scanner.nextLine(); //버퍼비우기
        return scanner.nextLine();
    }

    /* informFormat : 계산 양식을 사용자에게 알려주는 메소드 */
    @Override
    public void informFormat() {
        System.out.println("(피연산자와 연산자 사이에 공백을 입력해주세요.)");
    }

    /* inputError : 사용자가 메뉴 선택을 잘못했을 때 출력하는 에러 메소드 */
    @Override
    public void inputError() {
        System.out.println("입력이 잘못되었습니다.");
    }

    /* errorMessage : 예외 상황에 대해 메시지를 출력해주는 메소드 */
    @Override
    public void errorMessage(Exception e) {
        System.out.println("msg : " + e.toString());
    }

    /* exitMessage : 프로그램을 종료 메시지를 출력하는 메소드 */
    @Override
    public void exitMessage() {
        System.out.println("프로그램을 종료합니다.");
    }
}
