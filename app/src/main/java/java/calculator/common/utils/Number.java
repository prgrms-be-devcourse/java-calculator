package java.calculator.common.utils;

public class Number {
    private final String token;

    public Number(String token) {
        this.token = token;
    }

    public boolean isValid() {
        return this.token.matches("-?\\d+");
    }

    public int toInt() {
        return Integer.parseInt(this.token);
    }
}

