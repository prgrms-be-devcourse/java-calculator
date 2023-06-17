package calculator.domain;

import util.ExceptionMsg;
import util.IllegalException;
import util.ValidationEquation;

public class Calculator {
    private static final String EQUALS = " = ";

    private Calculate calculate;
    private String equation;
    private double result;

    public Calculator(Calculate calculate) {

        this.calculate = calculate;
    }

    public Calculator(String equation, double result) {
        this.equation =equation;
        this.result = result;
    }

    private static void validate(String equation) {
        if (ValidationEquation.isDivByZero(equation)) {
            throw new IllegalException(ExceptionMsg.NotSolveEquationException);
        }
    }

    public void calculate(String equation) {
        validate(equation);
        this.result = this.calculate.calculate(equation);
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
