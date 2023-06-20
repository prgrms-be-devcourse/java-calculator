package com.programmers.java;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class ConsoleService {

    private Calculator calculator;
    private Repository repository;
    private Scanner sc;
    boolean continueRunning;


    public ConsoleService(Calculator calculator, Repository repository) {
        this.calculator = calculator;
        this.repository = repository;
        this.sc = new Scanner(System.in);
        continueRunning = true;
    }

    public void run() {
        while (continueRunning) {
            ask();
            String option = getInput();
            continueRunning = interpret(option);
        }
    }

    public void ask() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("3. 종료");
        System.out.println();
        System.out.print("선택 : ");
    }

    public String getInput() {
        return sc.nextLine();
    }

    public boolean interpret(String option) {
        switch (option) {
            case "1":
                Map<String, BigDecimal> history = repository.showAll();
                history.entrySet().stream().forEach(entry -> {
                    String key = entry.getKey();
                    BigDecimal value = entry.getValue();
                    String stringFormat = String.format("%s = %s", key, value);
                    System.out.println(stringFormat);
                });
                break;
            case "2":
                String expression = getInput();
                if (expression.equals("q")) break;
                try {
                    BigDecimal result = calculator.calculate(expression);
                    repository.save(expression, result);
                    System.out.println(result);
                } catch (Exception e) {
                    System.out.println("올바르지 않은 수식입니다.");
                }
                break;
            case "3":
                return false;
            default:
                break;
        }
        return true;
    }
}
