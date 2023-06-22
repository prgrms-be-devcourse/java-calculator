package com.devcourse.java.calculator.io;

import com.devcourse.java.calculator.repository.History;
import com.devcourse.java.calculator.validator.equationValidator;
import com.devcourse.java.calculator.validator.repositoryValidator;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Console {

    private final Scanner scanner = new Scanner(System.in);

    public void printCommandMenu() {
        System.out.println();
        System.out.println("1. 조회");
        System.out.println("2. 계산");
        System.out.println("3. 종료");
        System.out.println();
        System.out.print("선택 : ");
    }

    public void printCalculateHistory(List<History> history) {
        repositoryValidator.checkCalculateHistoryLength(history);
        for (History eachHistory: history) {
            if (eachHistory.getAnswer().isEmpty()) {
                System.out.println(eachHistory.getEquation().get());
            } else {
                System.out.println(MessageFormat.
                        format("{0} = {1}", eachHistory.getEquation().get(), eachHistory.getAnswer().get()));
            }
        }

    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }

    public void printRequestEquationInput() {
        System.out.print("식을 입력하세요: ");
    }

    public void printAnswerFromEquation(String answer) {
        String[] splitAnswer = answer.split(" ");
        System.out.println(splitAnswer[splitAnswer.length - 1]);
    }

    public String getCommand() {
        return scanner.nextLine();
    }

    public Optional<String> getEquation() {
        String equation = scanner.nextLine();
        if (equation.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(equation);
    }
}
