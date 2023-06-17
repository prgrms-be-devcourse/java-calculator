package model;

public class Calculator {
    private Operation operation = new Operation();

    public String calculate(String expression) {

        String result = operation.operate(expression);

        return result;
    }


}
