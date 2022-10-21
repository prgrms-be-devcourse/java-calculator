package calculator.calculator.notation.parser;

import java.util.List;

public interface NotationParser {
    List<String> parseFrom(List<String> formulas);
}
