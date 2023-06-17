package com.devcourse;

import com.devcourse.calc.Calculator;
import com.devcourse.calc.converter.Converter;
import com.devcourse.calc.converter.ConverterNoBracket;
import com.devcourse.calc.repo.CalcHistoryRepository;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Converter converter = new ConverterNoBracket();
        CalcHistoryRepository repository = new CalcHistoryRepository();

        Console console = new Console(calculator, converter, repository);
        console.run();
    }
}