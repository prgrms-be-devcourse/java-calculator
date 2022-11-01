package com.programmers.devcourse.cli;

import com.programmers.devcourse.validation.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CommandLine {
    private BufferedReader bufferedReader;
    private final Validator validator;
    private static final int NOT_VALID = -1;

    private CommandLine() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.validator = Validator.getInstance();
    }

    private static class LazyHolder {
        private static final CommandLine INSTANCE = new CommandLine();
    }

    public static CommandLine getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void printOptionMessage() {
        System.out.print("1. 조회 2. 계산 3. 종료 \n\n선택: ");
    }

    public int readOption() {
        String optionStr;
        try {
            optionStr = bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (!validator.isNumber(optionStr)) {
            System.out.println("선택값이 유효하지 않습니다.");
            return NOT_VALID;
        }

        int optionInt = Integer.parseInt(optionStr);
        Optional<CommandOption> find = Arrays
                .stream(CommandOption.values())
                .filter(option -> option.getValue() == optionInt)
                .findFirst();

        if (find.isEmpty()) {
            System.out.println("선택값이 유효하지 않습니다.");
            return NOT_VALID;
        }

        return optionInt;
    }

    public String readExpression() {
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void stopCommandLine() {
        try {
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }

    public void printList(List<String> list) {
        if (list.isEmpty()) {
            System.out.println("저장된 데이터가 없습니다.");
        }
        for (String expression : list) {
            System.out.println(expression);
        }
    }


}
