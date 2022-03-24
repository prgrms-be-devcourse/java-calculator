package com.calculator.java.domain.console;

import com.calculator.java.domain.comand.Calculation;
import com.calculator.java.domain.comand.Command;
import com.calculator.java.domain.comand.Selection;
import com.calculator.java.domain.comand.Termination;
import com.calculator.java.domain.database.Database;

import java.io.*;
import java.util.*;

import static com.calculator.java.domain.comand.CommandTypes.*;

public class Console {
    private Validation validation;
    private Database database;
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Console(Validation validation, Database database) {
        this.validation = validation;
        this.database = database;
    }

    public boolean selectCommand() {
        try {
            showCommandType();
            Command command = getCommand(inputCommand());

            if(command instanceof Calculation) {
                String mathExpression = inputCommand();
                // validation
            }

            // doCommand ->  1 / 0 => return 연산 불가능
        } catch (Exception exception) {
            System.out.println(exception.getMessage());

            if (exception instanceof IOException) return false;
        }

        return true;
    }

    private void showCommandType() {
        StringBuilder sb = new StringBuilder();

        sb.append(SELECTION).append("\n")
                .append(CALCULATION).append("\n")
                .append(TERMINATION).append("\n")
                .append("\n선택 : ");

        System.out.print(sb);
    }

    private Command getCommand(String selectedCommand) throws Exception {
        if (selectedCommand.equals(SELECTION.getCommandId())) {
            return new Selection();
        } else if (selectedCommand.equals(CALCULATION.getCommandId())) {
            return new Calculation();
        } else if (selectedCommand.equals(TERMINATION.getCommandId())) {
            return new Termination();
        } else {
            throw new WrongInputException("잘 못된 입력입니다.");
        }
    }

    private String inputCommand() throws IOException {
        String tmp = br.readLine().trim();
        System.out.println();
        return tmp;
    }
}
