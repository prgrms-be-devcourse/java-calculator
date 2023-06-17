package com.programmers.io;

import com.programmers.model.UserEquation;
import com.programmers.util.Menu;
import com.programmers.validator.InputValidator;

import java.util.Map;
import java.util.Scanner;

public class Console implements Input, Output{

    private final String SELECT_MESSAGE = "선택 : ";
    private final Scanner scanner = new Scanner(System.in);
    private StringBuilder sb = new StringBuilder();

    @Override
    public String getRequest() {
        String userInput = scanner.nextLine();
        String request = userInput.replaceAll(" ", "");
        return request;
    }

    @Override
    public UserEquation getEquation() {
        String userInput = scanner.nextLine();
        String equation = userInput.replaceAll(" ", "");
        UserEquation userEquation = new UserEquation(equation);
        return userEquation;
    }

    @Override
    public void getMenu() {
        for (Menu m : Menu.values()) {
            println(m.getPrintMessage());
        }
        print(SELECT_MESSAGE);
    }

    @Override
    public <T> void println(T msg) {
        System.out.println(msg);
    }

    @Override
    public <T> void print(T msg) {
        System.out.print(msg);
    }

    @Override
    public void printErrorMsg(String errMsg) {
        System.out.println(errMsg);
    }

    @Override
    public void printResult(Map<String, Double> map) {
        if (map.isEmpty()) println("조회할 기록이 없습니다.");

        map.keySet().forEach(key -> {
            String equation = key;
            double answer = map.get(key);
            sb.append(equation).append(" = ").append(answer).append("\n");
        });
            println(sb.toString());
            sb.setLength(0);
    }
}