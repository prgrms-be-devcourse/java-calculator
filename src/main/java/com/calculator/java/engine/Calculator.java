package com.calculator.java.engine;

import com.calculator.java.console.Console;
import com.calculator.java.engine.comand.calculation.MathExpression;
import com.calculator.java.global.Enum.CommandTypes;
import com.calculator.java.global.exception.TerminationException;
import com.calculator.java.global.exception.WrongInputException;
import com.calculator.java.database.Database;
import com.calculator.java.engine.comand.calculation.Calculation;
import com.calculator.java.engine.comand.Commandable;
import com.calculator.java.engine.comand.inquiry.Inquiry;

import java.io.IOException;
import java.util.Optional;

public class Calculator {
    private Console console;

    public Calculator(Console console) {
        this.console = console;
    }

    public void run() {
        while (true) {
            try {
                console.showCommandType();
                String selectedCommand = console.inputCommandType();

                Commandable commandable = getCommand(selectedCommand).orElseThrow(TerminationException::new);

                String result = commandable.doCommand();
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

    private Optional<Commandable> getCommand(String selectedCommand) throws IOException, WrongInputException {
        CommandTypes commandType = CommandTypes.findCommandType(selectedCommand);

        switch (commandType) {
            case INQUIRY:
                return Optional.of(new Inquiry(Database.getInstance()));
            case CALCULATION:
                String mathExpression = console.inputMathExpression();
                return Optional.of(new Calculation(new MathExpression(mathExpression), Database.getInstance()));
            default:
                return Optional.empty();
        }
    }
}
