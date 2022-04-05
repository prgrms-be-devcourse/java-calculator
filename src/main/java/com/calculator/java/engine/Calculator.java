package com.calculator.java.engine;

import com.calculator.java.console.Console;
import com.calculator.java.global.Enum.CommandTypes;
import com.calculator.java.global.exception.TerminationException;
import com.calculator.java.global.exception.WrongInputException;
import com.calculator.java.database.Database;
import com.calculator.java.engine.comand.Calculation;
import com.calculator.java.engine.comand.Command;
import com.calculator.java.engine.comand.Inquiry;

import java.io.IOException;
import java.util.Optional;

public class Calculator {
    private Console console;
    private Database database;

    public Calculator(Console console, Database database) {
        this.console = console;
        this.database = database;
    }

    public void run() {
        while (true) {
            try {
                console.showCommandType();
                String selectedCommand = console.inputCommandType();

                Command command = getCommand(selectedCommand).orElseThrow(TerminationException::new);

                String result = command.doCommand();
                console.output(result);

            }catch (WrongInputException wrongInputException) {
              console.output(wrongInputException.getMessage());
            } catch (TerminationException terminationException){
                break;
            } catch (IOException ioException) {
                console.output(ioException.getMessage());
                break;
            }
        }
    }

    private Optional<Command> getCommand(String selectedCommand) throws IOException, WrongInputException {
        CommandTypes commandType = CommandTypes.findCommandType(selectedCommand);

        switch (commandType) {
            case INQUIRY:
                return Optional.of(new Inquiry(database));
            case CALCULATION:
                String mathExpression = console.inputMathExpression();
                return Optional.of(new Calculation(mathExpression, database));
            default:
                return Optional.empty();
        }
    }
}
