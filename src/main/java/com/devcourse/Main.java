package com.devcourse;

import com.devcourse.calc.Calculator;
import com.devcourse.calc.repo.CalcHistoryRepository;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new CalcHistoryRepository());
        while (true) {
            calculator.run();
        }
    }
}