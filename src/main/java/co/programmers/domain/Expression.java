package co.programmers.domain;

import co.programmers.exception.ExceptionMessage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expression {

    private static final Pattern EXPRESSION_FORMAT = Pattern.compile(
            "(\\d+\\s[\\+\\-\\*\\/]\\s)+\\d+"
    );
    private String expression;

    public Expression(String expression) {
        this.expression = expression;
        if (!validate()) {
            throw new ArithmeticException(ExceptionMessage.INVALID_EXPRESSION);
        }
    }

    private boolean validate() {
        Matcher matcher = EXPRESSION_FORMAT.matcher(expression);
        return matcher.matches();
    }

    public String getExpression() {
        return expression;
    }

    public String[] split(String delimiter) {
        return expression.split(delimiter);
    }
}
