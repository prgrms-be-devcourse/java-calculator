package com.kimhunki.java.calculator.engine;

import com.kimhunki.java.calculator.Console;
import com.kimhunki.java.calculator.db.ResultRepository;
import com.kimhunki.java.calculator.db.MemoryResultRepository;
import com.kimhunki.java.calculator.enums.MenuNumber;
import com.kimhunki.java.calculator.io.Input;
import com.kimhunki.java.calculator.io.Output;
import com.kimhunki.java.calculator.model.*;
import com.kimhunki.java.calculator.strategy.CalculatorStrategy;
import com.kimhunki.java.calculator.strategy.VerificationStrategy;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
public class Selector implements Runnable {
    Input input;
    Output output;
    Parser parser;
    ResultRepository resultRepository;

    @Override
    public void run( ) {

        Calculator calculator = new Calculator(input, output, parser, new RegularExpressionVerification(), new InfixCalculator(parser, new Operator()));// 2번 계산 기능을 위한 인스턴스
        Query query = new Query(output);
        while (true) {
            output.menuOutput();
            output.select();
            String selectString = input.input();
            MenuNumber menuNumber = parser.menuParser(selectString);
            if (menuNumber.equals(MenuNumber.ONE)) {
                query.printResult(resultRepository);
            } else if (menuNumber.equals(MenuNumber.TWO)) {
                calculator.calculate(resultRepository);
            } else if (menuNumber.equals(MenuNumber.THREE)) {
                output.end();
                break;
            } else output.inputError();
        }
    }


}
