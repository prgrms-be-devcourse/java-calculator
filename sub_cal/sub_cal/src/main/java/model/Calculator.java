package model;

public class Calculator {
    private Operator operator = new Operator();

    public Integer cal(String inputString) {


        int result = operator.operate(inputString);



         return result;
    }


}
