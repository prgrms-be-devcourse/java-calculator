import java.util.Arrays;

public enum Operator {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/");

    private final String operator;

    Operator(String operator) {
        this.operator = operator;
    }

    public static Operator getValue(String operator) {
        return Arrays.stream(values())
                .filter(elem -> elem.operator.equals(operator))
                .findFirst()
                .orElseThrow();
    }

    public static boolean isValidOperator(String argument) {
        return Arrays.stream(values())
                .anyMatch(element -> element.operator.equals(argument));
    }
}
