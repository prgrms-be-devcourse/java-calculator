package calculator;

public class Calculator {
    public static double plus(double operand1, double operand2) {
        return operand1+operand2;
    }

    public static double minus(double operand1, double operand2) {
        return operand1-operand2;
    }

    public static double multiply(double operand1, double operand2) {
        return operand1*operand2;
    }

    public static double divied(double operand1, double operand2){
        if(operand2 == 0.0) { throw new IllegalArgumentException(); }
        return operand1/operand2;
    }
}
