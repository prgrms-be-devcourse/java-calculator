package org.programmers.domain.expression;

import java.util.List;

public class ExpressionParam {

    private final List<String> postfix;

    private final String originalExpression;

    public List<String> getPostfix() {
        return postfix;
    }

    public String getOriginalExpression() {
        return originalExpression;
    }

    public ExpressionParam(List<String> postfix, String originalExpression) {
        this.postfix = postfix;
        this.originalExpression = originalExpression;
    }
}
