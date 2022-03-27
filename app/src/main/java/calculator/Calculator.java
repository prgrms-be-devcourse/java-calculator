package calculator;

public class Calculator {
    public double plus(double operand1, double operand2) {
        return operand1+operand2;
    }

    public double minus(double operand1, double operand2) {
        return operand1-operand2;
    }

    public double multiply(double operand1, double operand2) {
        return operand1*operand2;
    }

    public double divied(double operand1, double operand2){
        if(operand2 == 0.0) { throw new IllegalArgumentException(); }
        return operand1/operand2;
    }
}
