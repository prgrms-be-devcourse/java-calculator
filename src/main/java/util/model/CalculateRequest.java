package util.model;

import util.ValidationInput;

public class CalculateRequest {
    private String equation;

    public CalculateRequest(String equation) {
        ValidationInput.checkEquation(equation);
        this.equation = equation;
    }

    public String getEquation() {
        return equation;
    }
}
