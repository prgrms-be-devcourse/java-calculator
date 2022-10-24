package com.programmers.java.application;

import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;
import com.programmers.java.engine.model.History;

import java.util.Map;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public String readHistory(History history) {
        StringBuilder stringBuilder = new StringBuilder("\n");

        for (Map.Entry<String, Double> equation : history.getEquations().entrySet()) {
            if (checkInt(equation.getValue())) {
                stringBuilder.append(equation.getKey()).append(" = ").append(equation.getValue().intValue()).append("\n");
            } else {
                stringBuilder.append(equation.getKey()).append(" = ").append(equation.getValue()).append("\n");
            }
        }

        return stringBuilder.toString();
    }

    @Override
    public void inputError() {
        System.out.println("\n입력이 잘못되었습니다.");
    }

    @Override
    public void printAnswer(Double answer) {
        if (checkInt(answer)) {
            System.out.printf("%d\n\n", answer.intValue());
        } else {
            System.out.printf("%.3f\n\n", answer);
        }
    }

    @Override
    public void printHistory(String inputHistory) {
        System.out.println(inputHistory);
    }

    public boolean checkInt(Double answer) {
        if (answer == Math.floor(answer)) {
            return true;
        } else {
            return false;
        }
    }
}
