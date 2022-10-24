package calculator.engine.model;

import java.util.List;

public class Expression {
    private final List<String> expression;

    public Expression(List<String> expression) {
        this.expression = expression;
    }

    public List<String> getExpression() {
        return expression;
    }
}
