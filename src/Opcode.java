import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Opcode {
    PLUS("+", 1, (op1, op2) -> op1 + op2),
    MINUS("-", 1, (op1, op2) -> op1 - op2),
    MULTIPLY("*", 2, (op1, op2) -> op1 * op2),
    DIVIDE("/", 2, (op1, op2) -> op1 / op2),
    LEFTPARENTHESIS("(", 3, (op1, op2) -> 0.0),
    RIGHTPARENTHESIS(")", 3, (op1, op2) -> 0.0);

    private final String name;
    private final int priority;
    private final BiFunction<Double, Double, Double> expression;

    Opcode(String name, int priority, BiFunction<Double, Double, Double> expression) {
        this.name = name;
        this.priority = priority;
        this.expression = expression;
    }

    public static Opcode findOperator(String opName) {
        return Stream.of(values())
                .filter(opcode -> opcode.name.equals(opName))
                .findFirst()
                .orElse(null);
    }

    public double calculate(double op1, double op2) {
        return expression.apply(op1, op2);
    }

    public static boolean isOperator(String opName) {
        return Stream.of(values())
                .anyMatch(opcode -> opcode.name.equals(opName));
    }

    public static boolean isRightParenthesis(String s) {
        return s.equals(")");
    }

    public static boolean isLeftParenthesis(String s) { return s.equals("("); }

    public static boolean isParenthesis(String s) {
        return "()".contains(s);
    }

    public static boolean compareTo(Opcode opcode, String c) {
        Opcode opcode2 = findOperator(String.valueOf(c));
        return opcode.priority <= opcode2.priority;
    }

}
