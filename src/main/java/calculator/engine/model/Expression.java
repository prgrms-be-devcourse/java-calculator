package calculator.engine.model;

import calculator.application.io.enums.Characters;

import java.util.List;
import java.util.stream.Collectors;

public class Expression {
    private final List<String> expression;

    public Expression(List<String> expression) {
        this.expression = expression;
    }

    public List<String> getExpression() {
        return expression;
    }

    public String getLiteral() {
        return expression.stream()
                .collect(Collectors.joining(Characters.BLANK.toString()));
    }
}
