package calculator.engine.model;

import calculator.engine.enums.Operators;

class Operator {
    public int operate(int num1, int num2, Operators operators){
        switch (operators){
            case PLUS:
                return add(num1,num2);
            case MINUS:
                return substract(num1,num2);
            case MULTIPLICATION:
                return multiply(num1,num2);
            case DIVISION:
                return divide(num1,num2);
        }
        return 0;
    }
    private int add(int num1,int num2) {
        return num1 + num2;
    }
    private int substract(int num1,int num2) {
        return num1 - num2;
    }
    private int divide(int num1, int num2){
        return num1 / num2;
    }
    private int multiply(int num1,int num2){
        return num1 * num2;
    }
}