package com.programmers.javaCalculator;

import com.programmers.javaCalculator.component.Calculator;
import com.programmers.javaCalculator.component.Converter;
import com.programmers.javaCalculator.component.InfixToPostfixConverter;
import com.programmers.javaCalculator.component.PostfixCalculator;
import com.programmers.javaCalculator.repository.LocalRepository;
import com.programmers.javaCalculator.repository.Repository;
import com.programmers.javaCalculator.service.PostfixCalculatorService;

public class App {

    public static void main(String[] args) {
        Converter converter = new InfixToPostfixConverter();
        Calculator calculator = new PostfixCalculator();
        Repository db = new LocalRepository();

        new PostfixCalculatorService(calculator, converter, db).run();
    }

}
