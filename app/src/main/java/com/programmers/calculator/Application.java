package com.programmers.calculator;


import com.programmers.calculator.io.Console;
import com.programmers.calculator.processor.Calculator;
import com.programmers.calculator.processor.Validator;
import com.programmers.calculator.storage.OperationMemoryStorage;
import com.programmers.calculator.storage.OperationStorage;

import java.util.regex.Pattern;

public class Application {
    private final OperationStorage operationStorage;
    private final Console console;
    private final Calculator calculator;
    private final CommandFasade commandFasade;

    public Application() {
        this.operationStorage = new OperationMemoryStorage();
        this.console = new Console();
        this.calculator = new Calculator();
        this.commandFasade = new CommandFasade();
    }

    public void run() {
        while (true) {
            try {
                int mode = inputMode();
                commandFasade.excute(operationStorage, calculator, console, mode);
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int inputMode() {
        String inputModeStr = console.inputStr();
        if (!Pattern.matches(Validator.NUMBER_REGEX, inputModeStr))
            throw new IllegalArgumentException("잘못된 기능을 입력하셨습니다.");

        return Integer.parseInt(inputModeStr);
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
