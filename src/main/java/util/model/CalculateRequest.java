package util.model;

import util.ExceptionMsg;
import util.IllegalException;
import util.ValidationEquation;

public class CalculateRequest {
    private String equation;

    public CalculateRequest(String equation) {
        validate(equation);

        this.equation = equation;
    }

    private void validate(String equation) {
        if (ValidationEquation.isDivByZero(equation)) {
            throw new IllegalException(ExceptionMsg.NotSolveEquationException);
        }
    }

    public String getEquation() {
        return equation;
    }
}
