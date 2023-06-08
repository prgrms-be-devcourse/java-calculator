package calculator.domain;

import calculator.exception.NotSolveEquationException;
import calculator.exception.ValidationEquation;
import util.OperatorMap;

import java.util.List;
import java.util.Stack;

public class Calculator {
    private static final String EQUALS = " = ";

    private String equation;
    private double result;

    public Calculator(String equation, double result) {
        this.equation =equation;
        this.result = result;
    }

    public Calculator getCalculator() {
        return new Calculator(this.equation, this.result);
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return this.equation + EQUALS + this.result;
    }
}
