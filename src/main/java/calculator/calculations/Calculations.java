package calculator.calculations;

public class Calculations {
    final public static String DIVIDE_BY_ZERO = "0으로 나눌 수 없습니다.";
    public static int add(int a, int b) {
        return a + b;
    }

    public static int sub(int a, int b) {
        return a - b;
    }

    public static int mul(int a, int b) {
        return a * b;
    }

    public static int div(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException(DIVIDE_BY_ZERO);
        }
        return a / b;
    }
}
