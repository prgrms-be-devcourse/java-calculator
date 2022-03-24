package com.calculator.java.domain.console;

import com.calculator.java.domain.comand.Calculation;
import com.calculator.java.domain.comand.Command;
import com.calculator.java.domain.comand.Selection;
import com.calculator.java.domain.console.exception.TerminationException;
import com.calculator.java.domain.console.exception.WrongInputException;
import com.calculator.java.domain.database.Database;

import java.io.*;
import java.util.*;

import static com.calculator.java.domain.comand.CommandTypes.*;

public class Console {
    private final String WRONG_INPUT_MESSAGE = "잘 못된 입력입니다.";
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
            String selectedCommand = input();
            Command command = getCommand(selectedCommand).orElseThrow(()->new TerminationException());

            if(command instanceof Calculation) {
                String mathExpression = input();

                if(validation.validate(mathExpression)) ((Calculation) command).setMathExpression(mathExpression);
                else throw new WrongInputException(WRONG_INPUT_MESSAGE);
            }

            // doCommand

        }catch (WrongInputException wrongInputException) {
          System.out.println(wrongInputException.getMessage());
        } catch (TerminationException terminationException){
            return false;
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
            return false;
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

    private String input() throws IOException {
        String input = br.readLine().trim();
        System.out.println();
        return input;
    }

    private Optional<Command> getCommand(String selectedCommand) throws WrongInputException {
        if (selectedCommand.equals(SELECTION.getCommandId())) {
            return Optional.of(new Selection());
        } else if (selectedCommand.equals(CALCULATION.getCommandId())) {
            return Optional.of(new Calculation());
        } else if (selectedCommand.equals(TERMINATION.getCommandId())) {
            return Optional.empty();
        } else {
            throw new WrongInputException(WRONG_INPUT_MESSAGE);
        }
    }
}
