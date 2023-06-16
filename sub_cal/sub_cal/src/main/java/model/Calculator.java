package model;

public class Calculator {
    private Operation operation = new Operation();

    public Integer cal(String inputString) {


        int result = operation.operate(inputString);

        return result;
    }


}
