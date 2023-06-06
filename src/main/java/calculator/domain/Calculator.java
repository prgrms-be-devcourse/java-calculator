package calculator.domain;

import calculator.exception.NotSolveEquationException;
import calculator.exception.ValidationEquation;

public class Calculator {
    private String equation;
    private double result;

    public Calculator(String equation) {
        validate(equation);

        this.equation = equation;
    }

    private void validate(String equation) {
        if (ValidationEquation.isDivByZero(equation)) {
            throw new NotSolveEquationException();
        }
    }




    public double getResult() {
        return result;
    }
}
