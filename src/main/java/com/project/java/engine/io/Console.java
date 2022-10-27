package com.project.java.engine.io;

import com.project.java.engine.data.ResultFormat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Console implements Input, Output {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final String MENU = "1.조회\n2.계산\n종료하시려면 q or Q를 눌러주세요.";
    private static final String SPECIAL_CHARACTER_VALIDATOR_REGEX = "[^\\w+\\-*/\\s]";

    @Override
    public String getInput(String message) throws IOException {
        printMenu();
        System.out.print(message);
        return br.readLine();
    }

    @Override
    public String getExpression(String message) throws IOException {
        System.out.print(message);
        return br.readLine();
    }

    @Override
    public boolean validateInput(String input) {
        String validateResult = input.replaceAll(SPECIAL_CHARACTER_VALIDATOR_REGEX, "");
        if (validateResult.length() != input.length()) return false;
        return true;
    }

    @Override
    public void printResult(ResultFormat result) {
        String formattedResult = result.formatResult();
        System.out.println("\n" + formattedResult);
    }

    @Override
    public void printMenu() {
        System.out.println(MENU);
    }

    @Override
    public void inputError() {
        System.out.println("입력이 잘못되었습니다.");
    }

    @Override
    public void messageEmpty() {
        System.out.println("내역이 없습니다.");
    }

    @Override
    public void printHistory(List<String> historyList) {
        historyList.stream()
                .forEach(System.out::println);
    }
}
