package com.bona.javacalculator.core.calculator;

import com.bona.javacalculator.core.*;
import com.bona.javacalculator.util.Validator;

import java.util.List;
import java.util.Stack;

public class Calculator implements AbstractCalculator{


    @Override
    public double calculate(List<String> formula) {

        Stack<Double> numbers = new Stack<>();

        String split;

        double num1 = 0;
        double num2 = 0;

        for (int i = 0; i < formula.size(); i++) {

            split = formula.get(i);

            if (Validator.isNumber(split)) {
                numbers.push(Double.valueOf(split));
            } else {
                num2 = numbers.pop();
                num1 = numbers.pop();

                numbers.push(Operator.calculate(split, num1, num2));
            }
        }
        return numbers.pop();
    }

}
