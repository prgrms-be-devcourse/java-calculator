package com.programmers.java;

import com.programmers.java.engine.Lobby;
import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.programmers.java.engine.Menu;
import com.programmers.java.engine.io.exception.WrongInputException;

public class Console implements Output, Input {

    private final Scanner scanner = new Scanner(System.in);
    private final String validExpRegex;

    public Console(String validExpRegex) {
        this.validExpRegex = validExpRegex;
    }

    /* optionInput : prompt를 출력하고 정수를 입력 받는 메소드 */
    @Override
    public Menu optionInput(String prompt) throws WrongInputException {
        System.out.println(prompt);
        Optional<Menu> userMenu = Menu.getMenu(scanner.nextLine());
        if (userMenu.isEmpty()) throw new WrongInputException("존재하지 않는 메뉴입니다.");
        return userMenu.get();
    }

    /* strInput : prompt를 출력하고 문자열 한줄을 입력 받는 메소드 */
    @Override
    public String expressionInput(String prompt) throws WrongInputException {
        System.out.println(prompt);
        String userStr = scanner.nextLine();
        if (!Pattern.matches(validExpRegex, userStr)) throw new WrongInputException("올바르지 않은 계산식입니다.");
        return userStr;
    }

    /* informFormat : 계산 양식을 사용자에게 알려주는 메소드 */
    @Override
    public void informFormat() {
        System.out.println("(피연산자와 연산자 사이에 공백을 입력해주세요.)");
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
