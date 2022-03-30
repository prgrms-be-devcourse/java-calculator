import exception.CalculatorException;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Opcode {
    PLUS("+", 1, (op1, op2) -> op1 + op2),
    MINUS("-", 1, (op1, op2) -> op1 - op2),
    MULTIPLY("*", 2, (op1, op2) -> op1 * op2),
    DIVIDE("/", 2, (op1, op2) -> op1 / op2),
    LEFT_PARENTHESIS("(", 3, (op1, op2) -> 0.0),
    RIGHT_PARENTHESIS(")", 3, (op1, op2) -> 0.0);

    private final String name;
    private final int priority;
    private final BiFunction<Double, Double, Double> expression;

    Opcode(String name, int priority, BiFunction<Double, Double, Double> expression) {
        this.name = name;
        this.priority = priority;
        this.expression = expression;
    }

    public static Optional<Opcode> findOperator(String opName) {
        return Optional.ofNullable(Stream.of(values())
                .filter(opcode -> opcode.name.equals(opName))
                .findFirst()
                .orElse(null));
    }

    public double calculate(double op1, double op2) {
        return expression.apply(op1, op2);
    }

    /**
     * opName이 +-* /()중 하나인지 체크
     *
     * @param opName
     * @return
     */
    public static boolean isOperator(String opName) {
        return Stream.of(values())
                .anyMatch(opcode -> opcode.name.equals(opName));
    }

    public static boolean isRightParenthesis(String s) {
        return s.equals(")");
    }

    public static boolean isLeftParenthesis(String s) {
        return s.equals("(");
    }

    public static boolean isParenthesis(String s) {
        return "()".contains(s);
    }

    public static boolean comparePriority(Opcode opcode1, String strOpcode) {
        Opcode opcode2 = findOperator(String.valueOf(strOpcode)).orElseThrow(() -> new CalculatorException("비교하기 적절하지 않은 연산자."));
        return opcode1.priority <= opcode2.priority;
    }

}