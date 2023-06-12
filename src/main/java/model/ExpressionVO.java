package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionVO {
    private static final String EXPRESSION_PATTERN = "^[0-9]+(\\s[+\\-*/]\\s[0-9]+)+$";
    public static final String INVALID_EXPRESSION = "수식이 틀렸습니다.";
    private final String expression;

    public ExpressionVO(String expression) {
        validExpression(expression, INVALID_EXPRESSION);
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    private void validExpression(String expression, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(EXPRESSION_PATTERN);
        }
    }
}
