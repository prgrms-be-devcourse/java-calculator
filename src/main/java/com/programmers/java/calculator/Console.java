package com.programmers.java.calculator;

import com.programmers.java.calculator.io.Input;
import com.programmers.java.calculator.io.Output;
import com.programmers.java.calculator.model.ExpressionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Console {
    private final int IO_ERROR_CODE = -1;
    private final Input input;
    private final Output output;
    private final ExpressionRepository expressionRepository;
    private final ArithmeticModule arithmeticModule;

    public void printInputError(){
        output.printInputError();
        exit();
    }

    public void printMenu(){
        output.printMenu();
    }

    public Integer selectMenu() {
        try {
            return Integer.parseInt(input.input("선택 : "));
        } catch (NumberFormatException e){
            return IO_ERROR_CODE;
        }
    }

    public void printLogs(){
        output.printLogs(expressionRepository.findAll());
    }

    public void executeCalculation(){
        String expression = input.input("");
        String result;
        if (expressionRepository.cached(expression)) {
            result = expressionRepository.findById(expression);
        }
        else {
            result = arithmeticModule.execute(expression);
        }
        expressionRepository.save(expression, result);
        output.print(result);
    }

    private void exit() {
        output.printCloseConsole();
    }
}
