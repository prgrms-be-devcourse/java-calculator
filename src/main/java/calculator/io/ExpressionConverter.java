package calculator.io;

import java.util.ArrayList;

public interface ExpressionConverter {
    ArrayList<String> convert(String infixExpression);
}
