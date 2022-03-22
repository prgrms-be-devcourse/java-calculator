package hyuk;

public class Calculator {

    public int add(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    public int subtract(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    public int divide(int firstOperand, int secondOperand) {
        if (secondOperand == 0) {
            throw new IllegalStateException("0으로 나눌 수 없습니다.");
        }
        return firstOperand / secondOperand;
    }

    public int multiply(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}
