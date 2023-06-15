package org.programmers.expression;

import java.util.List;

public class ExpressionParam {
    private final List<String> formula;

    private final String originalExpression;

    public List<String> getFormula() {
        return formula;
    }

    public String getOriginalExpression() {
        return originalExpression;
    }

    public ExpressionParam(List<String> formula, String originalExpression) {
        this.formula = formula;
        this.originalExpression = originalExpression;
    }
}
