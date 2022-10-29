package com.programmers.cal;

import com.programmers.cal.engine.Calculator;
import com.programmers.cal.engine.exception.WrongOrderException;
import com.programmers.cal.engine.exit.ExitManager;
import com.programmers.cal.engine.io.Console;
import com.programmers.cal.engine.io.Input;
import com.programmers.cal.engine.io.MenuType;
import com.programmers.cal.engine.io.Output;
import com.programmers.cal.engine.operation.OperationManager;
import com.programmers.cal.engine.parse.ExpressionParser;
import com.programmers.cal.engine.postfix.PostfixManager;
import com.programmers.cal.engine.repository.RecordRepository;
import com.programmers.cal.engine.validator.ExpressionValidator;

public class Application {
    public static void main(String[] args) {
        Input input = new Console();
        Output output = new Console();
        Calculator calculator = Calculator.builder()
                .input(input)
                .output(output)
                .validator(new ExpressionValidator())
                .parser(new ExpressionParser())
                .postfix(new PostfixManager())
                .operation(new OperationManager())
                .repository(new RecordRepository())
                .exit(new ExitManager())
                .build();

        while (true) {
            try {
                output.requestInput();
                String inputString = input.inputOrder();
                MenuType menuType = MenuType.getMenuType(inputString);
                if (!calculator.run(menuType)) return;
            } catch (WrongOrderException e) {
                output.printWrongOrder();
            }
        }
    }
}