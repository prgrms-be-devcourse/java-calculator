package com.programmers.java.calculator;

import com.programmers.java.calculator.io.Input;
import com.programmers.java.calculator.io.Output;
import com.programmers.java.calculator.model.ExpressionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Console {
    private Input input;
    private Output output;
    private ExpressionRepository expressionRepository;
    private ArithmeticModule arithmeticModule;

    public void printMenu(){
        output.menu();
    }

    public Integer selectMenu() {
        return Integer.parseInt(input.input("선택 : "));
    }

    public void printLogs(){
        output.logs(expressionRepository.findAll());
    }

    public void executeCalculation(){
        String expression = input.input("");
        String result;
        if (expressionRepository.cached(expression))
            result = expressionRepository.findById(expression);
        else
            result = arithmeticModule.execute(expression);
        expressionRepository.save(expression, result);
        output.print(result);
    }
}
