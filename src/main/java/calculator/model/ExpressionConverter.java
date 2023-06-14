package calculator.model;

import java.util.List;

public interface ExpressionConverter {
    List<String> convert(String infixExpression);
}
