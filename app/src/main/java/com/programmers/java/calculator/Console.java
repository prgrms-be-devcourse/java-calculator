package com.programmers.java.calculator;

import com.programmers.java.calculator.engine.Input;
import com.programmers.java.calculator.engine.Output;
import com.programmers.java.calculator.model.Problem;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Integer selectOption() {
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println();
        System.out.print("선택 : ");

        String option = scanner.nextLine();
        return Integer.parseInt(option);
    }

    @Override
    public String inputProblem() {
        return scanner.nextLine();
    }

    @Override
    public void inputError() {
        System.out.println("잘못된 수식입니다");
    }

    @Override
    public void showAllProblemNAnswer(List<Problem> problemList) {
        problemList.stream()
                .forEach(System.out::println);
    }

    @Override
    public void showAnswer(Problem problem) {
        System.out.println();//problem에 있는 답 println
    }
}
