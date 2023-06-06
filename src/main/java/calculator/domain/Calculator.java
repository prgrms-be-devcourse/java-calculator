package calculator.domain;

import calculator.exception.NotSolveEquationException;
import calculator.exception.ValidationEquationException;

public class Calculator {
    private String equation;
    private double result;

    public Calculator(String equation) {
        validate(equation);

        this.equation = equation;
    }

    private void validate(String equation) {
        if (ValidationEquationException.isDivByZero(equation)) {
            throw new NotSolveEquationException();
        }
    }




    public double getResult() {
        return result;
    }
}
