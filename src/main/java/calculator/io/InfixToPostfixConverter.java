package calculator.io;

import java.util.ArrayList;

public interface InfixToPostfixConverter {
    ArrayList<String> convert(String infixExpression);
}
