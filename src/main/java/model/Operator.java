package model;

public class Operator {

    public double operate(double firstNum, double secondNum, String operation) {
        switch (operation) {
            case "+":
                return plus(firstNum, secondNum);
            case "-":
                return minus(firstNum, secondNum);
            case "*":
                return multiply(firstNum, secondNum);
            case "/":
                return divide(firstNum, secondNum);
            default:
                throw new IllegalArgumentException("잘못된 연산자가 입력되었습니다");
        }
    }

    private double plus(double firstNum, double secondNum){
        return firstNum + secondNum;
    }
    private double minus(double firstNum, double secondNum){
        return firstNum - secondNum;
    }
    private double multiply(double firstNum, double secondNum){
        return firstNum * secondNum;
    }
    private double divide(double firstNum, double secondNum){
        if(secondNum == 0 || Double.isInfinite(secondNum))
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        return firstNum / secondNum;
    }
}
