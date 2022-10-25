package com.programmers.java.application;

import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;
import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Equation;

import java.util.List;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void inputError() {
        System.out.println("입력이 잘못되었습니다.\n");
    }

    @Override
    public void printAnswer(Answer answer) {
        if (answer.checkInt()) {
            System.out.printf("%d\n\n", answer.getValue().intValue());
        } else {
            System.out.printf("%.3f\n\n", answer.getValue());
        }
    }

    @Override
    public void printHistory(List<Equation> history) {
        StringBuilder stringBuilder = new StringBuilder("\n");

        for (Equation equation : history) {
            stringBuilder.append(equation.getExpression()).append(" = ");
            if (equation.getAnswer().checkInt()) {
                stringBuilder.append(equation.getAnswer().getValue().intValue()).append("\n");
            } else {
                stringBuilder.append(equation.getAnswer().getValue()).append("\n");
            }
        }

        System.out.println(stringBuilder);
    }
}
