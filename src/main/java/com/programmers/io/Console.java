package com.programmers.io;

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
        String _request = scanner.nextLine();
        String request = _request.replaceAll(" ", "");
        InputValidator.checkRequest(request);
        return request;
    }

    @Override
    public String getEquation() {
        String _equation = scanner.nextLine();
        String equation = _equation.replaceAll(" ", "");
        InputValidator.checkEquation(equation);
        return equation;
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