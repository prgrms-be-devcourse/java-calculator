package com.calculator.java.engine;

import com.calculator.java.Console;
import com.calculator.java.engine.comand.CommandTypes;
import com.calculator.java.exception.TerminationException;
import com.calculator.java.exception.WrongInputException;
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

                if(command instanceof Calculation) {
                    String mathExpression = console.inputMathExpression();
                    ((Calculation) command).setMathExpression(mathExpression);
                }

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

    private Optional<Command> getCommand(String selectedCommand) throws WrongInputException {
        CommandTypes commandType = CommandTypes.strToCommandType(selectedCommand);

        switch (commandType) {
            case INQUIRY:
                return Optional.of(new Inquiry(database));
            case CALCULATION:
                return Optional.of(new Calculation(database));
            default:
                return Optional.empty();
        }
    }
}
