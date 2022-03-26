package calculator.utils;

import java.util.List;

public interface Parser {
    List<String> parsePostfix(String expression);
}
