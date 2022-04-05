package com.calculator.java.console;

import com.calculator.java.global.Enum.CommandTypes;
import com.calculator.java.global.exception.WrongInputException;

import java.io.*;
import java.util.*;

public class Console {
    private final String WRONG_INPUT_MESSAGE = "잘 못된 입력입니다.";
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private final Validator validator;

    public Console(Validator validator) {
        this.validator = validator;
    }

    public void showCommandType() {
        StringBuilder sb = new StringBuilder();

        Arrays.asList(CommandTypes.values())
                .forEach(commandType -> sb.append(commandType).append("\n"));
        sb.append("\n선택 : ");

        System.out.print(sb);
    }

    public String inputCommandType() throws IOException, WrongInputException{
        String selectedCommand = br.readLine().trim();
        System.out.println();

        if(!validator.validateSelectedCommand(selectedCommand)) {
            throw new WrongInputException(WRONG_INPUT_MESSAGE);
        }

        return selectedCommand;
    }

    public String inputMathExpression() throws IOException, WrongInputException{
        String mathExpression = br.readLine().trim();

        if(validator.validateMathExpression(mathExpression)) return mathExpression;
        else throw new WrongInputException(WRONG_INPUT_MESSAGE);
    }

    public void output(String result) {
        System.out.println(result+"\n");
    }
}
