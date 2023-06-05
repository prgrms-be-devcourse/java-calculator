package com.devcourse;

import com.devcourse.calc.Calculator;
import com.devcourse.calc.repo.CalcHistoryRepository;
import com.devcourse.util.Converter;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new CalcHistoryRepository(), new Converter());
        while (true) {
            calculator.run();
        }
    }
}