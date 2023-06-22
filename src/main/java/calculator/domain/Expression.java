package calculator.domain;

import calculator.domain.enums.Operator;
import calculator.exception.ApplicationException;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static calculator.exception.ErrorMessage.WRONG_EXPRESSION_EXCEPTION;

public class Expression {
    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    private final String expression;

    public Expression(String expression) {
        validate(expression);
        this.expression = expression;
    }

    public Iterator<String> getIterator() {
        return getExpressions().iterator();
    }

    public List<String> getExpressions() {
        return Arrays.asList(expression.split(" "));
    }

    private void validate(String expression) {
        validateBlank(expression);
        List<String> expressions = Arrays.asList(expression.split(" "));
        validateExpressionLength(expressions);
        validateOperatorOrder(expressions);
        validateOperandOrder(expressions);
    }

    private void validateBlank(String expression) {
        if (StringUtils.isBlank(expression)) {
            throw new ApplicationException(WRONG_EXPRESSION_EXCEPTION);
        }
    }

    private void validateOperatorOrder(List<String> expressions) {
        boolean isNotOperator = IntStream.range(0, expressions.size())
                .filter(index -> index % 2 == 1)
                .mapToObj(expressions::get)
                .anyMatch(element -> !Operator.checkOperator(element));

        if (isNotOperator) {
            throw new ApplicationException(WRONG_EXPRESSION_EXCEPTION);
        }
    }

    private void validateOperandOrder(List<String> expression) {
        boolean isNotOperand = IntStream.range(0, expression.size())
                .filter(index -> index % 2 == 0)
                .mapToObj(expression::get)
                .anyMatch(element -> !isNumeric(element));

        if (isNotOperand) {
            throw new ApplicationException(WRONG_EXPRESSION_EXCEPTION);
        }
    }

    private void validateExpressionLength(List<String> expression) {
        int length = expression.size();

        if (length % 2 == 0) {
            throw new ApplicationException(WRONG_EXPRESSION_EXCEPTION);
        }
    }

    private boolean isNumeric(String input) {
        return EXPRESSION_PATTERN.matcher(input).matches();
    }

    @Override
    public String toString() {
        return this.expression;
    }
}
