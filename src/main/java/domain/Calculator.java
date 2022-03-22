package domain;

public class Calculator {

    public void calculate(double num1, double num2, char operation) {
        switch (operation) {
            case '+' :
                plus(num1, num2);
                break;
            case '-' :
                minus(num1, num2);
                break;
            case '*' :
                multiply(num1, num2);
                break;
            case '/' :
                divide(num1, num2);
                break;
        }
    }

    private double plus(double num1, double num2){
        return num1 + num2;
    }
    private double minus(double num1, double num2){
        return num1 - num2;
    }
    private double multiply(double num1, double num2){
        return num1 * num2;
    }
    private double divide(double num1, double num2){
        if(num2 == 0) throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        return num1 / num2;
    }
}
