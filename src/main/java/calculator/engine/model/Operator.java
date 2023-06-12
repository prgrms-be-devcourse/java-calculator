package calculator.engine.model;

import calculator.engine.enums.Operators;

public class Operator {
    public int operate(int num1, int num2, Operators operators){
        switch (operators){
            case PLUS:
                return PlusCalcul(num1,num2);
            case MINUS:
                return MinusCalcul(num1,num2);
            case MULTIPLICATION:
                return MultiCalcul(num1,num2);
            case DIVISION:
                return DiviCalcul(num1,num2);
        }
        return 0;
    }

    private int PlusCalcul(int num1,int num2) {
        return num1 + num2;
    }

    private int MinusCalcul(int num1,int num2) {
        return num1 - num2;
    }

    private int DiviCalcul(int num1, int num2){
        return num1 / num2;
    }
    private int MultiCalcul(int num1,int num2){
        return num1 * num2;
    }
}
